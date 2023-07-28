package org.kainos.ea.exceptions;

public class FailedToGenerateTokenException extends Exception {
    @Override
    public String getMessage() {
        return "Failed to generate token";
    }
}
