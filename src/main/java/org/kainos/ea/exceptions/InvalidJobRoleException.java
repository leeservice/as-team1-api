package org.kainos.ea.exceptions;

public class InvalidJobRoleException extends Exception {
    @Override
    public String getMessage() {
        return "Invalid job role";
    }
}
