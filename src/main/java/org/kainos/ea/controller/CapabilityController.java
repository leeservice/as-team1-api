package org.kainos.ea.controller;

import io.swagger.annotations.Api;
import org.kainos.ea.dao.CapabilityDao;
import org.kainos.ea.exceptions.FailedToGetCapabilityException;
import org.kainos.ea.service.CapabilityService;
import org.kainos.ea.utility.DatabaseConnector;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("Capability API")
@Path("/api")
public class CapabilityController {
    private static CapabilityService capabilityService;

    public CapabilityController() {
        capabilityService = new CapabilityService(new CapabilityDao(), new DatabaseConnector());
    }

    public CapabilityController(CapabilityService service) {
        capabilityService = service;
    }

    @GET
    @Path("/capability")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCapabilities() {
        try {
            return Response.ok(capabilityService.getAllCapabilities()).build();
        } catch (FailedToGetCapabilityException e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        }
    }



}
