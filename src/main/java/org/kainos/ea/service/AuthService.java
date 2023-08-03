package org.kainos.ea.service;

import org.kainos.ea.dao.AuthDao;
import org.kainos.ea.exceptions.DatabaseConnectionException;
import org.kainos.ea.exceptions.FailedToGenerateTokenException;
import org.kainos.ea.exceptions.FailedToLoginException;
import org.kainos.ea.model.Login;
import org.kainos.ea.model.LoginRequest;
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

    public String login(LoginRequest loginRequest) throws FailedToGenerateTokenException, FailedToLoginException, DatabaseConnectionException, SQLException {
        try {
            if (authDao.validLogin(loginRequest, databaseConnector.getConnection())) {
                int userId = authDao.getUserIdFromEmail(loginRequest.getEmail(), databaseConnector.getConnection());
                return authDao.generateToken(userId, databaseConnector.getConnection());
            } else {
                throw new FailedToLoginException();
            }
        } catch (SQLException | DatabaseConnectionException e) {
            System.err.println(e.getMessage());
            throw new FailedToGenerateTokenException();
        }
    }
}
