package org.kainos.ea.controller;


import io.swagger.annotations.Api;
import org.kainos.ea.dao.AuthDao;
import org.kainos.ea.exceptions.FailedToGetJobRoleException;
import org.kainos.ea.exceptions.FailedToRegisterUserException;
import org.kainos.ea.model.RegisterUser;
import org.kainos.ea.service.AuthService;
import org.kainos.ea.utility.DatabaseConnector;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("Commit Connoisseurs API")
@Path("/api")
public class AuthController {

    AuthService authService;

    public AuthController() {
         authService= new AuthService(new AuthDao(), new DatabaseConnector());
    }

    @POST
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllJobRoles(RegisterUser user) {
        try {
            System.out.println(user.getEmail());
            System.out.println(user.getRole());
            authService.registerNewUser(user);
            return Response.status(201).build();
        } catch (FailedToRegisterUserException e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        }
    }

}
