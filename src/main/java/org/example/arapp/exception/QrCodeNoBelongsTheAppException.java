package org.example.arapp.exception;

public class QrCodeNoBelongsTheAppException extends RuntimeException {
    public QrCodeNoBelongsTheAppException() {
        super("QrCode not belongs the app");
    }
}
