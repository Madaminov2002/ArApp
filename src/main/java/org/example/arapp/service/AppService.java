package org.example.arapp.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.arapp.domain.App;
import org.example.arapp.dto.appdto.AppDto;
import org.example.arapp.exception.AppNameAlreadyExistsException;
import org.example.arapp.repo.AppRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AppService {
    private final AppRepository appRepository;

    public String save(AppDto dto) {
        Optional<App> byName = appRepository.findByName(dto.getName());
        if (byName.isPresent()) {
            throw new AppNameAlreadyExistsException(dto.getName());
        }

        appRepository.save(App.builder().name(dto.getName()).build());

        return "App created";
    }
}
