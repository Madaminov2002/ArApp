package org.example.arapp.exception;

public class QrCodeExpiredException extends RuntimeException {
    public QrCodeExpiredException(String qrCode) {
        super("QR code has expired: qrCode=["+qrCode+"]");
    }
}
