package org.kainos.ea.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.kainos.ea.exceptions.DatabaseConnectionException;

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
            dbCredentials = new DbCredentials();
            user = dbCredentials.getDbUser();
            password = dbCredentials.getDbPassword();
            host = dbCredentials.getDbHost();
            database = dbCredentials.getDbName();

            if (user == null || password == null || host == null)
                throw new IllegalArgumentException("Environment variables not set.");

            conn =
                    DriverManager.getConnection(
                            "jdbc:mysql://"
                                    + host
                                    + "/"
                                    + database
                                    + "?allowPublicKeyRetrieval=true&useSSL=false",
                            user,
                            password);

            return conn;
        } catch (Exception e) {
            throw new DatabaseConnectionException();
        }
    }
}
