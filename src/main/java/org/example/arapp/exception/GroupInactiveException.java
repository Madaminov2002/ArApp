package org.example.arapp.exception;

public class GroupInactiveException extends RuntimeException {
    public GroupInactiveException(String appName, String groupName) {
        super("The group is inactive: appName=["+appName+"], groupName=["+groupName+"]");
    }
}
