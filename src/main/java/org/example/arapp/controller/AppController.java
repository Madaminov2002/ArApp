package org.example.arapp.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.arapp.domain.App;
import org.example.arapp.dto.appdto.AppDto;
import org.example.arapp.repo.AppRepository;
import org.example.arapp.service.AppService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app")
@PreAuthorize("hasRole('ADMIN')")
public class AppController {
    private final AppService appService;
    private final AppRepository appRepository;

    @PostMapping("/save")
    public ResponseEntity<App> save(@RequestBody AppDto dto) {
        return ResponseEntity.ok(appService.save(dto));
    }

    @GetMapping("/show-all")
    public ResponseEntity<List<App>> showAll() {
        return ResponseEntity.ok(appRepository.findAll());
    }
}
