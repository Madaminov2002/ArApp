package org.example.arapp.exception;

public class UserIsNotRegistered extends RuntimeException {
    public UserIsNotRegistered() {
        super("User is not registered");
    }
}
