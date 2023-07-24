package org.kainos.ea.integrationTests;

import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import org.junit.jupiter.api.Test;
import org.kainos.ea.model.JobRole;
import org.kainos.ea.trueApplication;
import org.kainos.ea.trueConfiguration;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JobRoleControllerTest {
    static final DropwizardAppExtension<trueConfiguration> APP = new DropwizardAppExtension<>(trueApplication.class, null, new ResourceConfigurationSourceProvider());

    @Test
    void DeleteJobRole_shouldReturnDeletionJobRoles() {
        Response response = APP.client().target("http://localhost:8080job-roles/1").request(MediaType.APPLICATION_JSON).delete();

        assertEquals(200, response.getStatus());
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }
}
