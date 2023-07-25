package org.kainos.ea.exceptions;

public class FailedToCreateJobRoleException extends Exception {
    @Override
    public String getMessage() {
        return "Failed to create job role";
    }
}
