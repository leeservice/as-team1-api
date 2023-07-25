package org.kainos.ea.integrationTests;

import static org.junit.jupiter.api.Assertions.*;

import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;

import java.util.List;
import javax.ws.rs.core.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.model.JobRole;
import org.kainos.ea.trueApplication;
import org.kainos.ea.trueConfiguration;

@ExtendWith(DropwizardExtensionsSupport.class)
public class JobRoleControllerTest {

    static final DropwizardAppExtension<trueConfiguration> APP = new DropwizardAppExtension<>(trueApplication.class, null, new ResourceConfigurationSourceProvider());

    @Test
    void getAllJobRoles_shouldReturnListOfJobRoles() {
        Response response = APP.client().target("http://localhost:8080/api/job-roles").request().get();

        //Checks for 200 response code
        assertEquals(200, response.getStatus());
        List<JobRole> jobRoles = response.readEntity(List.class);
        //Checks if list returned has a size greater than 0
        assertTrue(jobRoles.size() > 0);


    }
}
