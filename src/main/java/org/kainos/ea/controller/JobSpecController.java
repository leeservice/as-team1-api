package org.kainos.ea.controller;

import io.swagger.annotations.Api;
import javax.ws.rs.Path;
import org.kainos.ea.service.JobSpecService;
import org.kainos.ea.utility.DatabaseConnector;
import org.kainos.ea.validator.JobSpecValidator;

@Api("Kainos Job Application")
@Path("/job-specification")
public class JobSpecController {

  private static JobSpecService jobSpecService;
  private static JobSpecValidator jobSpecValidator;

  public JobSpecController() {
    DatabaseConnector databaseConnector = new DatabaseConnector();
//    jobSpecService = new JobSpecService(new JobSpecDao(), databaseConnector);
    jobSpecValidator = new JobSpecValidator();
  }


}
