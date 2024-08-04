package org.example.arapp.exception;

public class QrCodeNotFoundException extends RuntimeException {
    public QrCodeNotFoundException(String qrCode) {
        super("QR code not found: qrCode=["+qrCode+"]");
    }
}
