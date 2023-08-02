package org.kainos.ea.controllerTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.controller.AuthController;
import org.kainos.ea.exceptions.DatabaseConnectionException;
import org.kainos.ea.exceptions.FailedToGenerateTokenException;
import org.kainos.ea.exceptions.FailedToLoginException;
import org.kainos.ea.model.LoginRequest;
import org.kainos.ea.service.AuthService;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

// Tests for the AuthController class
@ExtendWith(MockitoExtension.class)
public class AuthControllerTest {
    AuthService authService = mock(AuthService.class);
    AuthController authController = new AuthController(authService);
    LoginRequest loginRequest = new LoginRequest("user@kainos.com", "password");

    @Test
    void login_shouldReturn500_whenAuthServiceThrowsFailedToGenerateTokenException() throws DatabaseConnectionException, SQLException, FailedToLoginException, FailedToGenerateTokenException {
        when(authService.login(loginRequest)).thenThrow(FailedToGenerateTokenException.class);
        assertEquals(500, authController.login(loginRequest).getStatus());
    }

    @Test
    void login_shouldReturn500_whenAuthServiceThrowsSQLException() throws DatabaseConnectionException, SQLException, FailedToLoginException, FailedToGenerateTokenException {
        when(authService.login(loginRequest)).thenThrow(SQLException.class);
        assertEquals(500, authController.login(loginRequest).getStatus());
    }

    @Test
    void login_shouldReturn500_whenAuthServiceThrowsDatabaseConnectionException() throws DatabaseConnectionException, SQLException, FailedToLoginException, FailedToGenerateTokenException {
        when(authService.login(loginRequest)).thenThrow(DatabaseConnectionException.class);
        assertEquals(500, authController.login(loginRequest).getStatus());
    }
}
