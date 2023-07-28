package org.kainos.ea.exceptions;

public class FailedToLoginException extends Exception {
    @Override
    public String getMessage() {
        return "Failed to login";
    }
}
