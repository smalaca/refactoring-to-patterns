package com.smalaca.designpatterns.example.command.housecontrol.operation;

public class UnsupportedHomeOperationException extends RuntimeException {
    public static UnsupportedHomeOperationException anUnsupportedFanOperation() {
        return new UnsupportedHomeOperationException("Unsupported fan operation.");
    }

    public static UnsupportedHomeOperationException anUnsupportedLightOperation() {
        return new UnsupportedHomeOperationException("Unsupported light operation.");
    }

    private UnsupportedHomeOperationException(String message) {
        super(message);
    }
}
