package org.example.arapp.exception;

public class DeviceNumberLimitedException extends RuntimeException {
    public DeviceNumberLimitedException() {
        super("The number of devices is limited");
    }
}
