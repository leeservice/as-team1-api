package org.kainos.ea.service;

import org.kainos.ea.dao.AuthDao;
import org.kainos.ea.exceptions.DatabaseConnectionException;
import org.kainos.ea.exceptions.FailedToRegisterUserException;
import org.kainos.ea.exceptions.InvalidUserException;
import org.kainos.ea.model.RegisterUser;
import org.kainos.ea.utility.DatabaseConnector;
import org.kainos.ea.validator.RegisterUserValidator;

import java.sql.SQLException;

public class AuthService {
    public AuthDao authDao;

    public DatabaseConnector databaseConnector;

    private RegisterUserValidator validator = new RegisterUserValidator();

    public AuthService(AuthDao authDao, DatabaseConnector databaseConnector) {
        this.authDao = authDao;
        this.databaseConnector = databaseConnector;
    }


    public int register(RegisterUser log) throws FailedToRegisterUserException, DatabaseConnectionException, InvalidUserException {

        if(validator.isValidRegisterUser(log) != "") {
            throw new InvalidUserException(validator.isValidRegisterUser(log));
        }

        try {
            int id = authDao.register(log, databaseConnector.getConnection());
            if (id == -1) {
                throw new FailedToRegisterUserException();

            }
            return id;
        }catch (DatabaseConnectionException e){
            throw new FailedToRegisterUserException();
        } catch (SQLException e) {
            throw new FailedToRegisterUserException();
        }
    }
}
