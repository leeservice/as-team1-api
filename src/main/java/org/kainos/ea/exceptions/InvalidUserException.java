package org.kainos.ea.exceptions;

public class InvalidUserException extends Exception {

private String message;

    public InvalidUserException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "Invalid user - " + message + ".";
    }
}
