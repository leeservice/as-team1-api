package org.kainos.ea.controllerTests;

import org.junit.jupiter.api.Test;
import org.kainos.ea.controller.JobRoleController;
import org.kainos.ea.exceptions.DatabaseConnectionException;
import org.kainos.ea.exceptions.FailedToGetJobRoleException;
import org.kainos.ea.exceptions.JobRoleDoesNotExistException;
import org.kainos.ea.service.JobRoleService;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JobControllerTest {

    JobRoleService jobRoleService = mock(JobRoleService.class);
    JobRoleController jobRoleController = new JobRoleController(jobRoleService);

    @Test
    void DeleteJobRoles_shouldReturn500_whenJobRoleServiceThrowsFailedToGetJobRoleException() throws FailedToGetJobRoleException, JobRoleDoesNotExistException, DatabaseConnectionException, SQLException {
        when(jobRoleService.deleteJob(1)).thenThrow(FailedToGetJobRoleException.class);
        assertEquals(500, jobRoleController.deleteJobRole(1).getStatus());
    }

}
