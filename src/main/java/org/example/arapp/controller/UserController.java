package org.example.arapp.controller;

import jakarta.validation.Valid;
import org.example.arapp.dto.qrdto.InfoAboutQrCodeRespDto;
import org.example.arapp.dto.qrdto.QrCheckingForInformationReqDto;
import org.example.arapp.dto.userdto.UserCheckingReqDto;
import org.example.arapp.dto.userdto.UserRegisterDto;
import org.example.arapp.exception.UserAlreadyExist;
import org.example.arapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/check")
    public ResponseEntity checking(@RequestBody @Valid UserCheckingReqDto dto) {
        userService.checkingUser(dto);
        throw new UserAlreadyExist(dto.getDeviceId(), dto.getAppName());
    }

    @PostMapping("/register")
    public void signupUser(@RequestBody @Valid UserRegisterDto dto) {

        userService.register(dto);

    }

    @PostMapping("/qr/info")
    public ResponseEntity<InfoAboutQrCodeRespDto> checking(@RequestBody @Valid QrCheckingForInformationReqDto dto) {
        InfoAboutQrCodeRespDto info = userService.info(dto);
        return ResponseEntity.status(HttpStatus.FOUND).body(info);
    }


}
