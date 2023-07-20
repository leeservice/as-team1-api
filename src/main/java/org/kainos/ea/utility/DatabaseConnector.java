package org.kainos.ea.utility;

import org.kainos.ea.exceptions.DatabaseConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    private static Connection conn;
    private DbCredentials dbCredentials;

    public Connection getConnection() throws SQLException, DatabaseConnectionException {
        String user;
        String password;
        String host;
        String database;

        if (conn != null && !conn.isClosed()) {
            return conn;
        }

        try {
            System.out.println("}}}}}}Getting Credentials");
            user            = System.getenv("DB_USERNAME");
            password        = System.getenv("DB_PASSWORD");
            host            = System.getenv("DB_HOST");
            database        = System.getenv("DB_NAME");
            System.out.println("}}}}}}}}}Database Username:" + user);

            if (user == null || password == null || host == null)
                throw new IllegalArgumentException(
                        "Environment variables not set.");

            conn = DriverManager.getConnection("jdbc:mysql://"
                    + host + "/" + database + "?allowPublicKeyRetrieval=true&useSSL=false", user, password);


            return conn;
        } catch (Exception e) {
            throw new DatabaseConnectionException();
        }
    }
}
