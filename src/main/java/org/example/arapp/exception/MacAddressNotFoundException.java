package org.example.arapp.exception;

public class MacAddressNotFoundException extends RuntimeException {
    public MacAddressNotFoundException(String address) {
        super("Mac address not found: " + address);
    }
}
