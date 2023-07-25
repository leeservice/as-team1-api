package org.kainos.ea.exceptions;

public class DatabaseConnectionException extends Exception {
    @Override
    public String getMessage() {
        return "Failed to connect to the database.";
    }
}
