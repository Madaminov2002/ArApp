package org.example.arapp.advice;

import jakarta.servlet.http.HttpServletResponse;
import org.example.arapp.dto.authdto.ErrorResponseDto;
import org.example.arapp.exception.AppNameAlreadyExistsException;
import org.example.arapp.exception.AppNotFoundException;
import org.example.arapp.exception.DeviceIdNotFoundException;
import org.example.arapp.exception.GroupNameAlreadyExistsException;
import org.example.arapp.exception.MacAddressNotFoundException;
import org.example.arapp.exception.PasswordIncorrectException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MacAddressNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> macAddressNotFound(MacAddressNotFoundException exception) {
        return ResponseEntity.ok(
                ErrorResponseDto.builder()
                        .message(exception.getMessage())
                        .status(HttpStatus.NOT_FOUND)
                        .code(HttpServletResponse.SC_NOT_FOUND)
                        .build()
        );
    }

    @ExceptionHandler(DeviceIdNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> deviceIdNotFound(DeviceIdNotFoundException exception) {
        return ResponseEntity.ok(
                ErrorResponseDto.builder()
                        .message(exception.getMessage())
                        .status(HttpStatus.NOT_FOUND)
                        .code(HttpServletResponse.SC_NOT_FOUND)
                        .build()
        );
    }

    @ExceptionHandler(AppNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> appIddNotFound(AppNotFoundException exception) {
        return ResponseEntity.ok(
                ErrorResponseDto.builder()
                        .message(exception.getMessage())
                        .status(HttpStatus.NOT_FOUND)
                        .code(HttpServletResponse.SC_NOT_FOUND)
                        .build()
        );
    }

    @ExceptionHandler(PasswordIncorrectException.class)
    public ResponseEntity<ErrorResponseDto> incorrectPassword(PasswordIncorrectException exception) {
        return ResponseEntity.ok(
                ErrorResponseDto.builder()
                        .message(exception.getMessage())
                        .status(HttpStatus.BAD_REQUEST)
                        .code(HttpServletResponse.SC_BAD_REQUEST)
                        .build()
        );
    }

    @ExceptionHandler(AppNameAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> appNameAlreadyExistsException(AppNameAlreadyExistsException exception) {
        return ResponseEntity.ok(
                ErrorResponseDto.builder()
                        .message(exception.getMessage())
                        .status(HttpStatus.CONFLICT)
                        .code(HttpServletResponse.SC_CONFLICT)
                        .build()
        );
    }

    @ExceptionHandler(GroupNameAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> grNameAlreadyExistsException(GroupNameAlreadyExistsException exception) {
        return ResponseEntity.ok(
                ErrorResponseDto.builder()
                        .message(exception.getMessage())
                        .status(HttpStatus.CONFLICT)
                        .code(HttpServletResponse.SC_CONFLICT)
                        .build()
        );
    }

}
