package org.example.arapp.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.arapp.domain.QrCode;
import org.example.arapp.dto.qrdto.QrDto;
import org.example.arapp.service.GenerateService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/qrcode")
@PreAuthorize("hasRole('ADMIN')")
public class QrCodeController {
    private final GenerateService generateService;
    @PostMapping("/generate")
    public ResponseEntity<List<QrCode>> generate(@RequestBody QrDto dto){
        return ResponseEntity.ok(generateService.generateQrCode(dto));
    }

}
