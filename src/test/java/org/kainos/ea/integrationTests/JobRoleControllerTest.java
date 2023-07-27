package org.kainos.ea.integrationTests;

import static org.junit.jupiter.api.Assertions.*;

import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import java.util.List;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.model.JobRoleRequest;
import org.kainos.ea.model.JobRoleResponse;
import org.kainos.ea.trueApplication;
import org.kainos.ea.trueConfiguration;

@ExtendWith(DropwizardExtensionsSupport.class)
public class JobRoleControllerTest {

    static final DropwizardAppExtension<trueConfiguration> APP =
            new DropwizardAppExtension<>(
                    trueApplication.class, null, new ResourceConfigurationSourceProvider());

    @Test
    void getAllJobRoles_shouldReturnListOfJobRoles() {
        Response response =
                APP.client().target("http://localhost:8080/api/job-roles").request().get();
        assertEquals(200, response.getStatus());
        List<JobRoleResponse> jobRoles =
                response.readEntity(new GenericType<List<JobRoleResponse>>() {});
        assertTrue(jobRoles.size() > 0);
        JobRoleResponse jobRoleResponse = jobRoles.get(0);
        String expected = "Engineering";
        String actual = jobRoleResponse.getCapability();
        assertEquals(expected, actual);
    }

    @Test
    void createJobRole_shouldReturnIdOfJobRole() {
        JobRoleRequest jobRoleRequest = new JobRoleRequest("Test job role", "This is a description.", 1, 1, "https://kainos.com");
        Response response = APP.client().target("http://localhost:8080/api/job-roles").request().post(Entity.entity(jobRoleRequest, MediaType.APPLICATION_JSON_TYPE));
        // Check for 201 response code
        assertEquals(201, response.getStatus());
        int id = response.readEntity(Integer.class);
        // Check an integer is returned
        assertNotNull(id);
    }

    @Test
    void createJobRole_shouldReturn400_whenNameTooLong() {
        String longName = "name".repeat(1000);
        JobRoleRequest jobRoleRequest = new JobRoleRequest(longName, "This is a description.", 1, 1, "https://kainos.com");
        Response response = APP.client().target("http://localhost:8080/api/job-roles").request().post(Entity.entity(jobRoleRequest, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(400, response.getStatus());
    }

    @Test
    void createJobRole_shouldReturn400_whenNameIsEmpty() {
        JobRoleRequest jobRoleRequest = new JobRoleRequest("", "This is a description.", 1, 1, "https://kainos.com");
        Response response = APP.client().target("http://localhost:8080/api/job-roles").request().post(Entity.entity(jobRoleRequest, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(400, response.getStatus());
    }

    @Test
    void createJobRole_shouldReturn400_whenUrlTooLong() {
        String longUrl = "https://" + "a".repeat(1000) + ".com";
        JobRoleRequest jobRoleRequest = new JobRoleRequest("Test Job Role", "This is a description.", 1, 1, longUrl);
        Response response = APP.client().target("http://localhost:8080/api/job-roles").request().post(Entity.entity(jobRoleRequest, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(400, response.getStatus());
    }
}
