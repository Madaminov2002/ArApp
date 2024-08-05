package org.example.arapp.exception;

public class GroupNotFoundException extends RuntimeException {
    public GroupNotFoundException(String name) {
        super("Group  not found with: " + name);
    }
}
