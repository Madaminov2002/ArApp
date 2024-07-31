package org.example.arapp.exception;

public class GroupNameAlreadyExistsException extends RuntimeException {
    public GroupNameAlreadyExistsException(String name) {
        super("Group name already exists in this app: " + name);
    }
}
