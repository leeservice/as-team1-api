package org.kainos.ea.integrationTests;


import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.dao.JobRoleDao;
import org.kainos.ea.exceptions.DatabaseConnectionException;
import org.kainos.ea.model.JobRole;
import org.kainos.ea.model.JobRoleRequest;
import org.kainos.ea.trueApplication;
import org.kainos.ea.trueConfiguration;
import org.kainos.ea.utility.DatabaseConnector;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@ExtendWith(DropwizardExtensionsSupport.class)
public class JobRoleControllerTest {
    static final DropwizardAppExtension<trueConfiguration> APP = new DropwizardAppExtension<>(trueApplication.class, null, new ResourceConfigurationSourceProvider());

    @Test
    void getAllJobRoles_shouldReturnListOfJobRoles() {
        Response response = APP.client().target("http://localhost:8080/api/job-roles").request().get();

        //Checks for 200 response code
        List<JobRoleRequest> jobRoles = response.readEntity(new GenericType<List<JobRoleRequest>>() {
        });
        assertTrue(jobRoles.size() > 0);
        JobRoleRequest jobRoleResponse = jobRoles.get(0);
        String expected = "Engineering";
        String actual = jobRoleResponse.getCapability();
        assertEquals(expected, actual);
    }

}

