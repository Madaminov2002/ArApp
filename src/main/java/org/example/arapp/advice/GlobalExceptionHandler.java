package org.example.arapp.advice;

import jakarta.servlet.http.HttpServletResponse;
import org.example.arapp.dto.authdto.ErrorResponseDto;
import org.example.arapp.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserIsNotRegistered.class)
    public ResponseEntity<ErrorResponseDto> validationError(UserIsNotRegistered exception) {
        return ResponseEntity.ok(
                ErrorResponseDto.builder()
                        .message(exception.getMessage())
                        .status(HttpStatus.UNAUTHORIZED)
                        .code(HttpServletResponse.SC_UNAUTHORIZED)
                        .build()
        );
    }

    @ExceptionHandler(UserAlreadyExist.class)
    public ResponseEntity<ErrorResponseDto> validationError(UserAlreadyExist exception) {
        return ResponseEntity.ok(
                ErrorResponseDto.builder()
                        .message(exception.getMessage())
                        .status(HttpStatus.ACCEPTED)
                        .code(HttpServletResponse.SC_ACCEPTED)
                        .build()
        );
    }

    @ExceptionHandler(QrCodeNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> validationError(QrCodeNotFoundException exception) {
        return ResponseEntity.ok(
                ErrorResponseDto.builder()
                        .message(exception.getMessage())
                        .status(HttpStatus.NOT_FOUND)
                        .code(HttpServletResponse.SC_NOT_FOUND)
                        .build()
        );
    }

    @ExceptionHandler(QrCodeNoBelongsTheAppException.class)
    public ResponseEntity<ErrorResponseDto> validationError(QrCodeNoBelongsTheAppException exception) {
        return ResponseEntity.ok(
                ErrorResponseDto.builder()
                        .message(exception.getMessage())
                        .status(HttpStatus.NOT_ACCEPTABLE)
                        .code(HttpServletResponse.SC_NOT_ACCEPTABLE)
                        .build()
        );
    }

    @ExceptionHandler(QrCodeExpiredException.class)
    public ResponseEntity<ErrorResponseDto> validationError(QrCodeExpiredException exception) {
        return ResponseEntity.ok(
                ErrorResponseDto.builder()
                        .message(exception.getMessage())
                        .status(HttpStatus.NOT_ACCEPTABLE)
                        .code(HttpServletResponse.SC_NOT_ACCEPTABLE)
                        .build()
        );
    }

    @ExceptionHandler(GroupInactiveException.class)
    public ResponseEntity<ErrorResponseDto> validationError(GroupInactiveException exception) {
        return ResponseEntity.ok(
                ErrorResponseDto.builder()
                        .message(exception.getMessage())
                        .status(HttpStatus.NOT_ACCEPTABLE)
                        .code(HttpServletResponse.SC_NOT_ACCEPTABLE)
                        .build()
        );
    }

    @ExceptionHandler(DeviceNumberLimitedException.class)
    public ResponseEntity<ErrorResponseDto> validationError(DeviceNumberLimitedException exception) {
        return ResponseEntity.ok(
                ErrorResponseDto.builder()
                        .message(exception.getMessage())
                        .status(HttpStatus.NOT_ACCEPTABLE)
                        .code(HttpServletResponse.SC_NOT_ACCEPTABLE)
                        .build()
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> validationError(MethodArgumentNotValidException exception) {
        return ResponseEntity.ok(
                ErrorResponseDto.builder()
                        .message(exception.getMessage())
                        .status(HttpStatus.NOT_ACCEPTABLE)
                        .code(HttpServletResponse.SC_NOT_ACCEPTABLE)
                        .build()
        );
    }

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
