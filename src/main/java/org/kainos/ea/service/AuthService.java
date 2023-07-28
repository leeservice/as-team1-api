package org.kainos.ea.service;

import org.kainos.ea.dao.AuthDao;
import org.kainos.ea.exceptions.DatabaseConnectionException;
import org.kainos.ea.exceptions.FailedToGenerateTokenException;
import org.kainos.ea.exceptions.FailedToLoginException;
import org.kainos.ea.model.Login;
import org.kainos.ea.utility.DatabaseConnector;

import java.sql.Connection;
import java.sql.SQLException;

public class AuthService {
    public AuthDao authDao;
    public DatabaseConnector databaseConnector;

    public AuthService(AuthDao authDao, DatabaseConnector databaseConnector) {
        this.authDao = authDao;
        this.databaseConnector = databaseConnector;
    }

    public String login(Login login) throws FailedToGenerateTokenException, FailedToLoginException, DatabaseConnectionException, SQLException {
        if (authDao.validLogin(login, databaseConnector.getConnection())) {
            try {
                return authDao.generateToken(login.getId(), databaseConnector.getConnection());
            } catch (SQLException | DatabaseConnectionException e) {
                System.err.println(e.getMessage());
                throw new FailedToGenerateTokenException();
            }
        }

        throw new FailedToLoginException();
    }
}
