package org.kainos.ea.integrationTests;


import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.model.JobRoleResponse;
import org.kainos.ea.trueApplication;
import org.kainos.ea.trueConfiguration;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@ExtendWith(DropwizardExtensionsSupport.class)
public class JobRoleControllerTest {
    static final DropwizardAppExtension<trueConfiguration> APP = new DropwizardAppExtension<>(trueApplication.class, null, new ResourceConfigurationSourceProvider());

    @Test
    void getAllJobRoles_shouldReturnListOfJobRoles() {
        Response response = APP.client().target("http://localhost:8080/api/job-roles").request().get();
        List<JobRoleResponse> jobRoles = response.readEntity(new GenericType<List<JobRoleResponse>>() {
        });
        assertTrue(jobRoles.size() > 0);
        JobRoleResponse jobRoleResponse = jobRoles.get(0);
        String expected = "Manager";
        String actual = jobRoleResponse.getBandLevel();
        assertEquals(expected, actual);
    }

}

