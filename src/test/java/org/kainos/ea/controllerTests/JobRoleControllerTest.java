package org.kainos.ea.controllerTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.controller.JobRoleController;
import org.kainos.ea.exceptions.FailedToCreateJobRoleException;
import org.kainos.ea.exceptions.FailedToGetJobRoleException;
import org.kainos.ea.exceptions.InvalidJobRoleException;
import org.kainos.ea.exceptions.JobRoleDoesNotExistException;
import org.kainos.ea.model.JobRoleRequest;
import org.kainos.ea.service.JobRoleService;
import org.mockito.junit.jupiter.MockitoExtension;

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
    void updateAllJobRoles_shouldReturn500_whenJobRoleServiceThrowsFailedToGetJobRoleException()
            throws  JobRoleDoesNotExistException, InvalidJobRoleException, FailedToCreateJobRoleException {
        JobRoleRequest jobRoleRequest = new JobRoleRequest("Test job role", "This is a description.", 1, 9,"https://kainos.com" );

        when(jobRoleService.updateJobRole(1, jobRoleRequest)).thenThrow(FailedToCreateJobRoleException.class);
        assertEquals(500, jobRoleController.getAllJobRoles().getStatus());
    }
}
