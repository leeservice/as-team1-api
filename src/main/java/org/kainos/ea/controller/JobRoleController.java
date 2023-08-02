package org.kainos.ea.controller;

import io.swagger.annotations.Api;

import javax.ws.rs.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.kainos.ea.dao.JobRoleDao;
import org.kainos.ea.exceptions.FailedToCreateJobRoleException;
import org.kainos.ea.exceptions.FailedToGetJobRoleException;
import org.kainos.ea.exceptions.InvalidJobRoleException;
import org.kainos.ea.exceptions.JobRoleDoesNotExistException;
import org.kainos.ea.model.JobRoleRequest;
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

    @POST
    @Path("/job-roles")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createJobRole(JobRoleRequest jobRoleRequest) {
        try {
            return Response.status(Response.Status.CREATED).entity(jobRoleService.createJobRole(jobRoleRequest)).build();
        } catch (FailedToCreateJobRoleException e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        } catch (InvalidJobRoleException e) {
            System.err.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
    @GET
    @Path("/products/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductById(@PathParam("id") int id)
    {
        try {
            return Response.ok(jobRoleService.getJobRoleById(id)).build();
        } catch (FailedToGetJobRoleException e) {
            System.err.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (JobRoleDoesNotExistException e) {
            throw new RuntimeException(e);
        }
    }
    @PUT
    @Path("/job-roles/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateJobRole(@PathParam("id") int id, JobRoleRequest jobRoleRequest)
    {
        try {
            jobRoleService.updateJobRole(id,jobRoleRequest);
            return Response.ok().build();
        }catch (FailedToCreateJobRoleException e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        } catch (InvalidJobRoleException e) {
            System.err.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (JobRoleDoesNotExistException e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        }
    }
}
