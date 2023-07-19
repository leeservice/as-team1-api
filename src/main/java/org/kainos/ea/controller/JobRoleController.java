package org.kainos.ea.controller;

import io.swagger.annotations.Api;
import javax.ws.rs.Path;
import org.kainos.ea.service.JobSpecService;
import org.kainos.ea.utility.DatabaseConnector;
import org.kainos.ea.validator.JobRoleValidator;

@Api("Kainos Job Application")
@Path("/job-specification")
public class JobRoleController {
    private static JobSpecService jobSpecService;
    private static JobRoleValidator jobSpecValidator;

    public JobRoleController() {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        //    jobSpecService = new JobSpecService(new JobSpecDao(), databaseConnector);
        jobSpecValidator = new JobRoleValidator();
    }
}