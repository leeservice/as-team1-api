package org.kainos.ea.utility;

public class DbCredentials {
    private String dbName = System.getenv("DB_NAME");
    private String dbUser = System.getenv("DB_USERNAME");
    private String dbPassword = System.getenv("DB_PASSWORD");
    private String dbHost = System.getenv("DB_HOST");

    public String getDbName() {
        return dbName;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public String getDbHost() {
        return dbHost;
    }
}