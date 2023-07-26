package org.kainos.ea.controller;

import io.swagger.annotations.Api;
import org.kainos.ea.dao.BandDao;
import org.kainos.ea.exceptions.FailedToGetBandException;
import org.kainos.ea.service.BandService;
import org.kainos.ea.utility.DatabaseConnector;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("Band API")
@Path("/api")
public class BandController {
    private static BandService bandService;

    public BandController() {
        bandService = new BandService(new BandDao(), new DatabaseConnector());
    }

    public BandController(BandService service) {
        bandService = service;
    }

    @GET
    @Path("/band")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBands() {
        try {
            return Response.ok(bandService.getAllBands()).build();
        } catch (FailedToGetBandException e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        }
    }
}
