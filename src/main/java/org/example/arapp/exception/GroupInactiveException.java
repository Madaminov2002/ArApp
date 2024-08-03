package org.example.arapp.exception;

public class GroupInactiveException extends RuntimeException {
    public GroupInactiveException() {
        super("The group is inactive");
    }
}
