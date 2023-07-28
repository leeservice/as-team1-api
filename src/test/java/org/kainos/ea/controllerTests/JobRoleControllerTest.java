package org.kainos.ea.controllerTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.controller.JobRoleController;
import org.kainos.ea.dao.JobRoleDao;
import org.kainos.ea.exceptions.DatabaseConnectionException;
import org.kainos.ea.exceptions.FailedToGetJobRoleException;
import org.kainos.ea.exceptions.JobRoleDoesNotExistException;
import org.kainos.ea.service.JobRoleService;
import org.mockito.junit.jupiter.MockitoExtension;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JobRoleControllerTest {
    JobRoleService jobRoleService = mock(JobRoleService.class);
    JobRoleController jobRoleController = new JobRoleController(jobRoleService);

    @Test
    void getAllJobRoles_shouldReturn500_whenJobRoleServiceThrowsFailedToGetJobRoleException()
            throws FailedToGetJobRoleException {
        when(jobRoleService.getAllJobRoles()).thenThrow(FailedToGetJobRoleException.class);
        assertEquals(500, jobRoleController.getAllJobRoles().getStatus());
    }
    @Test
    void DeleteJobRoles_shouldReturn500_whenJobRoleServiceThrowsFailedToGetJobRoleException() throws FailedToGetJobRoleException, JobRoleDoesNotExistException, DatabaseConnectionException, SQLException {
        when(jobRoleService.deleteJob(1)).thenThrow(FailedToGetJobRoleException.class);
        assertEquals(500, jobRoleController.deleteJobRole(1).getStatus());
    }
}
