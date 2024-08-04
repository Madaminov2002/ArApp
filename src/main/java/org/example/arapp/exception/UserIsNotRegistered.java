package org.example.arapp.exception;

public class UserIsNotRegistered extends RuntimeException {
    public UserIsNotRegistered(String deviceId) {
        super("User is not registered: deviceId=["+deviceId+"]");
    }
}
