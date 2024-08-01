package org.example.arapp.exception;

public class QrCodeNotFoundException extends RuntimeException {
    public QrCodeNotFoundException() {
        super("QR code not found");
    }
}
