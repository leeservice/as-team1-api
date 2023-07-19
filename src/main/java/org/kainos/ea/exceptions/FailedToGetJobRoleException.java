package org.kainos.ea.exceptions;

public class FailedToGetJobRoleException extends Exception {
    @Override
    public String getMessage() {
        return "Failed to get job role";
    }
}
