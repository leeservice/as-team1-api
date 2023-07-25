package org.kainos.ea.integrationTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.controller.JobRoleController;
import org.kainos.ea.exceptions.FailedToGetJobRoleException;
import org.kainos.ea.model.JobRole;
import org.kainos.ea.service.JobRoleService;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.ws.rs.core.Response;

import java.util.List;

import static org.eclipse.osgi.internal.loader.buddy.SystemPolicy.APP;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JobRoleControllerTest {
    JobRoleService jobRoleService = mock(JobRoleService.class);
    JobRoleController jobRoleController = new JobRoleController(jobRoleService);

    @Test
    void getAllJobRoles_shouldReturn500_whenJobRoleServiceThrowsFailedToGetJobRoleException() throws FailedToGetJobRoleException {
        when(jobRoleService.getAllJobRoles()).thenThrow(FailedToGetJobRoleException.class);
        assertEquals(500, jobRoleController.getJobRoles().getStatus());
    }

}


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