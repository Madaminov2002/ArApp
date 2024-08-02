package org.example.arapp.exception;

public class AppNotFoundException extends RuntimeException {
    public AppNotFoundException(String name) {
        super("App  not found with: " + name);
    }
}
