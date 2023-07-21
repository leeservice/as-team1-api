package org.kainos.ea.integrationTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import java.util.List;
import javax.ws.rs.core.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.controller.JobRoleController;
import org.kainos.ea.model.JobRole;
import org.kainos.ea.trueApplication;
import org.kainos.ea.trueConfiguration;

@ExtendWith(DropwizardExtensionsSupport.class)
public class JobRoleControllerTest {

    static final DropwizardAppExtension<trueConfiguration> APP = new DropwizardAppExtension<>(trueApplication.class, null, new ResourceConfigurationSourceProvider());
    JobRoleController jobRoleController = new JobRoleController();
    @Test
    void getJobRoles_shouldReturnListOfJobRoles() {
        List<JobRole> response = APP.client().target("http://localhost:8080/api/job-roles").request().get(List.class);
        Assertions.assertTrue(response.size() > 0);
    }


    @Test
    void getJobRoles_shouldReturn200_whenJobRoleListReturned(){
        Response response = APP.client().target("http://localhost:8080/api/job-roles")
            .request()
            .get();
        assertEquals(200, response.getStatus());
    }

//    @Test
//    void getJobRoles_shouldThrowFailedToGetJobRoleException_whenJobRoleServiceFailsToGetJobRoleException() {
//        List<JobRole> jobRoleList = APP.client().target("http://localhost:8080/api/job-roles")
//            .request().get(List.class);
//        assertThrows(FailedToGetJobRoleException.class,
//            () -> jobRoleController.getJobRoles());
//    }

}

