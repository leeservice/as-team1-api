package org.kainos.ea.serviceTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.dao.AuthDao;
import org.kainos.ea.exceptions.DatabaseConnectionException;
import org.kainos.ea.exceptions.FailedToGenerateTokenException;
import org.kainos.ea.exceptions.FailedToGetJobRoleException;
import org.kainos.ea.exceptions.FailedToLoginException;
import org.kainos.ea.model.LoginRequest;
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
    LoginRequest loginRequest = mock(LoginRequest.class);
    AuthService authService = new AuthService(authDao, databaseConnector);
    Connection conn;

    @Test
    void login_shouldThrowFailedToGenerateTokenException_whenDaoThrowsSQLException() throws DatabaseConnectionException, SQLException {
        when(databaseConnector.getConnection()).thenReturn(conn);
        when(authDao.validLogin(loginRequest, conn)).thenReturn(true);
        when(authDao.getUserIdFromEmail(loginRequest.getEmail(), conn)).thenThrow(SQLException.class);
        assertThrows(FailedToGenerateTokenException.class, () -> authService.login(loginRequest));
    }

    @Test
    void login_shouldThrowFailedToGenerateTokenException_whenDatabaseConnectorThrowsDatabaseConnectionException() throws DatabaseConnectionException, SQLException {
        when(databaseConnector.getConnection()).thenThrow(DatabaseConnectionException.class);
        assertThrows(FailedToGenerateTokenException.class, () -> authService.login(loginRequest));
    }

    @Test
    void login_shouldReturnToken_whenDaoReturnsTrue() throws DatabaseConnectionException, SQLException, FailedToGenerateTokenException, FailedToGetJobRoleException, FailedToLoginException {
        when(databaseConnector.getConnection()).thenReturn(conn);
        when(authDao.validLogin(loginRequest, conn)).thenReturn(true);
        when(authDao.getUserIdFromEmail(loginRequest.getEmail(), conn)).thenReturn(1);
        when(authDao.generateToken(1, conn)).thenReturn("token");
        assertEquals("token", authService.login(loginRequest));
    }

    @Test
    void login_shouldThrowFailedToLoginException_whenDaoReturnsFalse() throws DatabaseConnectionException, SQLException {
        when(databaseConnector.getConnection()).thenReturn(conn);
        when(authDao.validLogin(loginRequest, conn)).thenReturn(false);
        assertThrows(FailedToLoginException.class, () -> authService.login(loginRequest));
    }

}
