package org.kainos.ea.controllerTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.controller.JobRoleController;
import org.kainos.ea.exceptions.FailedToGetJobRoleException;
import org.kainos.ea.service.JobRoleService;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JobRoleControllerTest {
    JobRoleService jobRoleService = mock(JobRoleService.class);
    JobRoleController jobRoleController = new JobRoleController(jobRoleService);

    @Test
    void getAllJobRoles_shouldReturn500_whenJobRoleServiceThrowsFailedToGetJobRoleException() throws FailedToGetJobRoleException {
        when(jobRoleService.getAllJobRoles()).thenThrow(FailedToGetJobRoleException.class);
        assertEquals(500, jobRoleController.getAllJobRoles().getStatus());
    }

}
