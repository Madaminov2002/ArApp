package org.example.arapp.service;

import org.example.arapp.domain.QrCode;
import org.example.arapp.domain.User;
import org.example.arapp.domain.UsersQrCode;
import org.example.arapp.dto.userdto.UserCheckingReqDto;
import org.example.arapp.dto.userdto.UserRegisterDto;
import org.example.arapp.exception.*;
import org.example.arapp.repo.QrCodeRepository;
import org.example.arapp.repo.UserRepository;
import org.example.arapp.repo.UsersQrCodeRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final QrCodeRepository qrCodeRepository;
    private final UsersQrCodeRepository usersQrCodeRepository;

    public UserService(UserRepository userRepository, QrCodeRepository qrCodeRepository, UsersQrCodeRepository usersQrCodeRepository) {
        this.userRepository = userRepository;
        this.qrCodeRepository = qrCodeRepository;
        this.usersQrCodeRepository = usersQrCodeRepository;
    }

    public boolean checkingUser(UserCheckingReqDto dto) {

        Optional<User> user = checkFromDatabase(dto.getDeviceId());

        if (user.isPresent()) {



            return true;
        }

        return false;

    }

    public void register(UserRegisterDto dto) {

        //////// checking what user is available
        Optional<User> userOptional = checkFromDatabase(dto.getDeviceId());
        boolean isPresentUser = userOptional.isPresent();
        User user;

        if (isPresentUser) {
            user = userOptional.get();

            user.getQrCode().forEach(a -> {

                if (a.getGroup().getApp().getName().equals(dto.getAppName())) {
                    throw new UserAlreadyExist();
                }

            });
        }

        ///////// getting qr code entity from entity
        String qrCodeString = dto.getQrCode();
        Optional<QrCode> qrCodeOptional = qrCodeRepository.findByCode(qrCodeString);
        if (qrCodeOptional.isEmpty()) {
            throw new QrCodeNotFoundException();
        }

        QrCode qrCodeEntity = qrCodeOptional.get();


        ////////  Checking Qr kode with filter
        checkAppNameEqualQrAppName(dto.getAppName(), qrCodeEntity);

        checkValidatingQrCode(qrCodeEntity);

        checkDeviceCapacityCount(qrCodeEntity);

        ///////////// saving user to database

        if (isPresentUser) {
            user = userOptional.get();
            user.getQrCode().add(qrCodeEntity);
        } else {
            user = new User();
            user.setDeviceId(dto.getDeviceId());
            user.setQrCode(List.of(qrCodeEntity));
        }

        userRepository.save(user);
    }

    private void checkDeviceCapacityCount(QrCode qrCode) {
        List<UsersQrCode> usersQrCodes = usersQrCodeRepository.findById_QrCodeId(qrCode.getId());

        int avaCount = usersQrCodes.size();

        if (avaCount >= qrCode.getDeviceCount()) {
            throw new DeviceNumberLimitedException();
        }

    }

    private void checkAppNameEqualQrAppName(String appName, QrCode qrCodeEntity) {
        if (!qrCodeEntity.getGroup().getApp().getName().equals(appName)) {
            throw new QrCodeNoBelongsTheAppException();
        }
    }

    private void checkValidatingQrCode(QrCode qrCode) {

        if (qrCode.getGroup().getActive()) {
            if (qrCode.getExpiryTime().before(new Date())) throw new QrCodeExpiredException();
        } else {
            throw new GroupInactiveException();
        }

    }

    private Optional<User> checkFromDatabase(String deviceId) {

        return userRepository.findByDeviceId(deviceId);

    }

}
