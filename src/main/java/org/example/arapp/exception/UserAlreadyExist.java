package org.example.arapp.exception;

public class UserAlreadyExist extends RuntimeException {
    public UserAlreadyExist(String deviceId, String appName) {
        super("User is already exist with: deviceId=["+deviceId+"]"+", appName=["+appName+"]");
    }
}
