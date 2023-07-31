package org.kainos.ea.service;

import org.kainos.ea.dao.AuthDao;
import org.kainos.ea.exceptions.DatabaseConnectionException;
import org.kainos.ea.exceptions.FailedToRegisterUserException;
import org.kainos.ea.model.RegisterUser;
import org.kainos.ea.utility.DatabaseConnector;

import java.sql.SQLException;

public class AuthService {
    public AuthDao authDao;

    public DatabaseConnector databaseConnector;

    public AuthService(AuthDao authDao, DatabaseConnector databaseConnector) {
        this.authDao = authDao;
        this.databaseConnector = databaseConnector;
    }

    public boolean registerNewUser(RegisterUser user) throws FailedToRegisterUserException {
        try {
            authDao.registerNewUser(databaseConnector.getConnection(), user);
        } catch (SQLException | DatabaseConnectionException e) {
            System.err.println(e.getMessage());
            throw new FailedToRegisterUserException();
        }
        return true;
    }

}
