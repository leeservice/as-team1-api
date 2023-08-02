package org.kainos.ea.exceptions;

public class FailedToGetCapabilityException extends Exception {
    @Override
    public String getMessage() {
        return "Failed to get capability";
    }
}
