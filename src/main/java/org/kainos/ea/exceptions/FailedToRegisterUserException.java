package org.kainos.ea.exceptions;

public class FailedToRegisterUserException extends Exception {
    @Override
    public String getMessage() {
        return "Failed to register user.";
    }
}
