package org.example.arapp.exception;

public class DeviceIdNotFoundException extends RuntimeException {
    public DeviceIdNotFoundException(String id) {
        super("Device ID not found: " + id);
    }
}
