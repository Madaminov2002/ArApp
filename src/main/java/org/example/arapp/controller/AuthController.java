package org.example.arapp.controller;

import lombok.RequiredArgsConstructor;
import org.example.arapp.dto.authdto.AdminLoginDto;
import org.example.arapp.dto.authdto.AuthUpdateDto;
import org.example.arapp.jwt.JwtResponse;
import org.example.arapp.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/admin-login")
    public ResponseEntity<JwtResponse> adminLogin(@RequestBody AdminLoginDto dto) {
        return ResponseEntity.ok(authService.adminLogin(dto));
    }

    @PutMapping("/update-password")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> updatePassword(@RequestBody AuthUpdateDto dto){
        authService.updatePassword(dto);
        return ResponseEntity.ok("Password updated successfully");
    }

}
