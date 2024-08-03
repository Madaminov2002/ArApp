package org.example.arapp.exception;

public class QrCodeExpiredException extends RuntimeException {
    public QrCodeExpiredException() {
        super("QR code has expired");
    }
}
