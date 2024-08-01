package org.example.arapp.controller;

import jakarta.validation.Valid;
import org.example.arapp.dto.userdto.UserCheckingReqDto;
import org.example.arapp.dto.userdto.UserRegisterDto;
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
        if (userService.checkingUser(dto)) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
    }

    @PostMapping("/register")
    public void signupUser(@RequestBody @Valid UserRegisterDto dto) {

        userService.register(dto);

    }

}
