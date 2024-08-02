package org.example.arapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import org.example.arapp.domain.App;
import org.example.arapp.domain.Group;
import org.example.arapp.domain.QrCode;
import org.example.arapp.dto.qrdto.QrDto;
import org.example.arapp.dto.qrdto.QrUpdateDto;
import org.example.arapp.exception.AppNotFoundException;
import org.example.arapp.repo.AppRepository;
import org.example.arapp.repo.GroupRepository;
import org.example.arapp.repo.QrCodeRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenerateService {
    private final QrCodeRepository qrCodeRepository;
    private final AppRepository appRepository;
    private final GroupRepository groupRepository;

    public List<QrCode> generateQrCode(QrDto dto) {
        Optional<App> app = appRepository.findByName(dto.getAppName());

        if (app.isEmpty()) {
            throw new AppNotFoundException(dto.getAppName());
        }

        List<Group> groupsByAppId = groupRepository.findGroupsByAppId(app.get().getId());
        Optional<Group> group = groupsByAppId.stream().filter(groups -> groups.getName().equals(dto.getGrName())).findFirst();

        List<QrCode> qrCodes = new ArrayList<>();
        for (int i = 0; i < dto.getCount(); i++) {

            boolean active = true;
            String qr = randomUniqueCode();

            Optional<QrCode> first = qrCodeRepository.findAll().stream()
                    .filter(qrCode -> qrCode.getCode().equalsIgnoreCase(qr)).findFirst();

            if (first.isPresent()) {
                active = false;
            }

            if (active) {
                qrCodes.add(
                        QrCode.builder()
                                .deviceCount(dto.getDeviceCount())
                                .expiryTime(dto.getExpirationDate())
                                .group(group.get())
                                .code(qr)
                                .build()
                );

            }

        }
        return qrCodeRepository.saveAll(qrCodes);

    }

    private String randomUniqueCode() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        return IntStream.range(0, 12)
                .mapToObj(i -> String.valueOf(characters.charAt(random.nextInt(characters.length()))))
                .collect(Collectors.joining());
    }

    public void update(QrUpdateDto dto) {
        Optional<App> app = appRepository.findByName(dto.getAppName());
        if (app.isEmpty()) {
            throw new AppNotFoundException(dto.getAppName());
        }

        Optional<Group> group = groupRepository.findGroupsByAppId(app.get().getId()).stream()
                .filter(groups -> groups.getName().equalsIgnoreCase(dto.getGrName())).findFirst();

        if (dto.getDeviceCount() != null) {
            qrCodeRepository.updateQrCodesDeviceCount(group.get().getId(), dto.getDeviceCount());
        }

        if (dto.getExpiryTime() != null) {
            qrCodeRepository.updateQrCodesExpiryTime(group.get().getId(), dto.getExpiryTime());
        }

    }
}
