package org.kainos.ea.controller;

import io.swagger.annotations.Api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.kainos.ea.dao.JobRoleDao;
import org.kainos.ea.exceptions.FailedToGetJobRoleException;
import org.kainos.ea.service.JobRoleService;
import org.kainos.ea.utility.DatabaseConnector;


@Api("Commit Connoisseurs API")
@Path("/api")
public class JobRoleController {
    private  JobRoleService jobRoleService;

    public JobRoleController() {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        jobRoleService = new JobRoleService(new JobRoleDao(), databaseConnector);
    }
    public JobRoleController(JobRoleService service) {
        jobRoleService = service;
    }

    @GET
    @Path("/job-roles")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllJobRoles() {
        try {
            return Response.ok(jobRoleService.getAllJobRoles()).build();
        } catch (FailedToGetJobRoleException e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        }
    }
}
