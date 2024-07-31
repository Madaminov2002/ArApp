package org.example.arapp.exception;

public class AppNotFoundException extends RuntimeException {
    public AppNotFoundException(Long id) {
        super("App id not found: " + id);
    }
}
