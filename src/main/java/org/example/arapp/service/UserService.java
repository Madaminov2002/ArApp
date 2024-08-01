package org.example.arapp.service;

import org.example.arapp.domain.QrCode;
import org.example.arapp.domain.User;
import org.example.arapp.dto.userdto.UserCheckingReqDto;
import org.example.arapp.dto.userdto.UserRegisterDto;
import org.example.arapp.exception.QrCodeNotFoundException;
import org.example.arapp.exception.UserAlreadyExist;
import org.example.arapp.repo.QrCodeRepository;
import org.example.arapp.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final QrCodeRepository qrCodeRepository;

    public UserService(UserRepository userRepository, QrCodeRepository qrCodeRepository) {
        this.userRepository = userRepository;
        this.qrCodeRepository = qrCodeRepository;
    }

    public boolean checkingUser(UserCheckingReqDto dto) {

        Optional<User> user = checkFromDatabase(dto.getDeviceId(), dto.getAppName());

        if (user.isPresent()) {

//            user.get().

            return true;
        }

        return false;

    }

    public void register(UserRegisterDto dto) {
        Optional<User> userOptional = checkFromDatabase(dto.getDeviceId(), dto.getAppName());
        if (userOptional.isPresent()) {
            throw new UserAlreadyExist();
        }


        String qrCodeString = dto.getQrCode();
        Optional<QrCode> qrCodeOptional = qrCodeRepository.findByCode(qrCodeString);
        if (qrCodeOptional.isEmpty()) {
            throw new QrCodeNotFoundException();
        }

        QrCode qrCodeEntity = qrCodeOptional.get();



        checkValidatingQrCode(qrCodeEntity);


    }

    private void checkValidatingQrCode(QrCode qrCode) {

//        qrCodeRepository.find

    }

    private Optional<User> checkFromDatabase(String deviceId, String appName) {
        Optional<User> byAppNameAndDeviceId = userRepository.findByDeviceIdAndAppName(deviceId, appName);

        return byAppNameAndDeviceId;
    }

}
