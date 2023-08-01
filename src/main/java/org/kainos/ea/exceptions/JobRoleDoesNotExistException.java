package org.kainos.ea.exceptions;

public class JobRoleDoesNotExistException extends Exception {
    @Override
    public String getMessage() {
        return "Job role does not exist";
    }
}
