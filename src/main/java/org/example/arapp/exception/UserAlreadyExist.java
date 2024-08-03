package org.example.arapp.exception;

public class UserAlreadyExist extends RuntimeException {
    public UserAlreadyExist() {
        super("User is already exist");
    }
}
