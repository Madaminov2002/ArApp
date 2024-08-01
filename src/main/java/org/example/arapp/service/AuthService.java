package org.example.arapp.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.arapp.domain.Admin;
import org.example.arapp.dto.authdto.AdminLoginDto;
import org.example.arapp.exception.DeviceIdNotFoundException;
import org.example.arapp.exception.MacAddressNotFoundException;
import org.example.arapp.exception.PasswordIncorrectException;
import org.example.arapp.jwt.JwtProvider;
import org.example.arapp.jwt.JwtResponse;
import org.example.arapp.repo.AdminRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public JwtResponse adminLogin(AdminLoginDto dto) {
        Optional<Admin> adminByMacAddress = adminRepository.findAdminByMacAddress(dto.getMacAddress());
        if (adminByMacAddress.isEmpty()) {
            throw new MacAddressNotFoundException(dto.getMacAddress());
        }
        Optional<Admin> adminByDeviceId = adminRepository.findAdminByDeviceId(dto.getDeviceID());
        if (adminByDeviceId.isEmpty()) {
            throw new DeviceIdNotFoundException(dto.getDeviceID());
        }
        if (passwordEncoder.matches(dto.getPassword(), adminByDeviceId.get().getPassword())) {
            throw new PasswordIncorrectException(dto.getPassword());
        }

        String token = jwtProvider.generate(adminByDeviceId.get());

        return new JwtResponse(token);
    }

}
