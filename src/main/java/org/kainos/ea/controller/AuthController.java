package org.kainos.ea.controller;

import io.swagger.annotations.Api;
import org.kainos.ea.dao.AuthDao;
import org.kainos.ea.exceptions.DatabaseConnectionException;
import org.kainos.ea.exceptions.FailedToGenerateTokenException;
import org.kainos.ea.exceptions.FailedToLoginException;
import org.kainos.ea.model.Login;
import org.kainos.ea.model.LoginRequest;
import org.kainos.ea.service.AuthService;
import org.kainos.ea.utility.DatabaseConnector;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("Authentication API")
@Path("/api")
public class AuthController {
    private static AuthService authService;

    public AuthController() {
        authService = new AuthService(new AuthDao(), new DatabaseConnector());
    }

    public AuthController(AuthService service) {
        authService = service;
    }

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LoginRequest loginRequest) {
        try {
            return Response.ok(authService.login(loginRequest)).build();
        } catch (FailedToLoginException e) {
            System.err.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (FailedToGenerateTokenException | DatabaseConnectionException | SQLException e) {
            System.err.println(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
