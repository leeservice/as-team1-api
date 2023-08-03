package org.kainos.ea.serviceTests;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.dao.AuthDao;
import org.kainos.ea.exceptions.DatabaseConnectionException;
import org.kainos.ea.exceptions.FailedToRegisterUserException;
import org.kainos.ea.exceptions.InvalidUserException;
import org.kainos.ea.model.RegisterUser;
import org.kainos.ea.model.enums.UserRole;
import org.kainos.ea.service.AuthService;
import org.kainos.ea.utility.DatabaseConnector;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {


    AuthDao authDao = mock(AuthDao.class);
    DatabaseConnector databaseConnector = mock(DatabaseConnector.class);
    AuthService authService = new AuthService(authDao, databaseConnector);
    Connection conn;

    RegisterUser login = new RegisterUser("JTeague@gmail.com", "Lee@YourService123", UserRole.EMPLOYEE);

    @Test
    void registerUser_shouldThrowFailedToRegisterUser_whenDaoThrowsSQLException() throws DatabaseConnectionException, SQLException {
        when(databaseConnector.getConnection()).thenReturn(conn);
        when(authDao.register(login, conn)).thenThrow(SQLException.class);
        assertThrows(FailedToRegisterUserException.class, () -> authService.register(login));
    }

    @Test
    void registerUser_shouldThrowFailedToRegisterUser_whenDatabaseConnectorThrowsDatabaseConnectionException() throws DatabaseConnectionException, SQLException {
        when(databaseConnector.getConnection()).thenThrow(DatabaseConnectionException.class);
        assertThrows(FailedToRegisterUserException.class, () -> authService.register(login));
    }

    @Test
    void registerUser_shouldReturnId_whenUserRegisteredSuccessfully() throws DatabaseConnectionException, SQLException, FailedToRegisterUserException, InvalidUserException {
        int id = 1;
        when(databaseConnector.getConnection()).thenReturn(conn);
        when(authDao.register(login, conn)).thenReturn(id);
        assertEquals(id, authService.register(login));
    }



}
