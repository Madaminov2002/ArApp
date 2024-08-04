package org.example.arapp.exception;

public class DeviceNumberLimitedException extends RuntimeException {
    public DeviceNumberLimitedException(String qrCode, int limit) {
        super("The number of devices is limited: qrCode=["+qrCode+"], deviceLimit=["+limit+"]");
    }
}
