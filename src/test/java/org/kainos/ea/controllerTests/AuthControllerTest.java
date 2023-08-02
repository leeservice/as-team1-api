package org.kainos.ea.controllerTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.controller.AuthController;
import org.kainos.ea.controller.JobRoleController;
import org.kainos.ea.exceptions.DatabaseConnectionException;
import org.kainos.ea.exceptions.FailedToGetJobRoleException;
import org.kainos.ea.exceptions.FailedToRegisterUserException;
import org.kainos.ea.model.RegisterUser;
import org.kainos.ea.model.enums.UserRole;
import org.kainos.ea.service.AuthService;
import org.kainos.ea.service.JobRoleService;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthControllerTest {
    AuthService authService = mock(AuthService.class);
    AuthController authController = new AuthController(authService);

    RegisterUser login = new RegisterUser("JTeague", "Lee@YourService123", UserRole.EMPLOYEE);

    Connection conn;

    @Test
    void registerUser_shouldReturn500_whenAuthServiceThrowsFailedToRegisterUserException()
            throws FailedToRegisterUserException, DatabaseConnectionException {
        when(authService.Register(login)).thenThrow(FailedToRegisterUserException.class);
        assertEquals(500, authController.createLogin(login).getStatus());
    }

}
