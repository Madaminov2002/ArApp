package org.example.arapp.exception;

public class QrCodeNoBelongsTheAppException extends RuntimeException {
    public QrCodeNoBelongsTheAppException(String qrCode) {
        super("This Qr code not belongs the app: qrCode=["+qrCode+"]");
    }
}
