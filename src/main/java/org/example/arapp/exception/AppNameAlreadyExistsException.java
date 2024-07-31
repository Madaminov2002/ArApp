package org.example.arapp.exception;

public class AppNameAlreadyExistsException extends RuntimeException {
    public AppNameAlreadyExistsException(String name) {
        super("App name already exists with name: " + name);
    }
}
