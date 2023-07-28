package org.kainos.ea.integrationTests;


import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.dao.JobRoleDao;
import org.kainos.ea.exceptions.DatabaseConnectionException;
import org.kainos.ea.model.JobRole;
import org.kainos.ea.model.JobRoleNoId;
import java.util.List;
import javax.ws.rs.core.GenericType;
import org.kainos.ea.trueApplication;
import org.kainos.ea.trueConfiguration;
import org.kainos.ea.utility.DatabaseConnector;

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
    void DeleteJobRole_shouldReturnDeletionJobRoles() throws DatabaseConnectionException, SQLException {
        JobRoleNoId job = new JobRoleNoId("Engineer", "Amazing",
                "https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Forms/AllItems.aspx?id=%2Fpeople%2FJob%20Specifications%2FEngineering%2FJob%20Profile%20%2D%20Principal%20Architect%20%28Principal%29%2Epdf&parent=%2Fpeople%2FJob%20Specifications%2FEngineering&p=true&ga=1", 1, 1);
        DatabaseConnector databaseConnector = new DatabaseConnector();
        JobRoleDao dao = new JobRoleDao();
        int JobID = dao.createJobRoleToDelete(job, databaseConnector.getConnection());
        Response response = APP.client().target("http://localhost:8080/api/job-roles/" + JobID).request().delete();

        assertEquals(200, response.getStatus());
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }
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
}
