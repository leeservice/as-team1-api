package org.kainos.ea.controllerTests;

import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.controller.JobRoleController;
import org.kainos.ea.dao.JobRoleDao;
import org.kainos.ea.exceptions.DatabaseConnectionException;
import org.kainos.ea.exceptions.FailedToGetJobRoleException;
import org.kainos.ea.model.JobRole;
import org.kainos.ea.service.JobRoleService;
import org.kainos.ea.trueApplication;
import org.kainos.ea.trueConfiguration;
import org.kainos.ea.utility.DatabaseConnector;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


    @ExtendWith(MockitoExtension.class)
    public class JobRoleControllerTests {
        JobRoleService jobRoleService = mock(JobRoleService.class);
        JobRoleController jobRoleController = new JobRoleController(jobRoleService);

        @Test
        void getAllJobRoles_shouldReturn500_whenJobRoleServiceThrowsFailedToGetJobRoleException() throws FailedToGetJobRoleException {
            when(jobRoleService.getAllJobRoles()).thenThrow(FailedToGetJobRoleException.class);
            assertEquals(500, jobRoleController.getJobRoles().getStatus());
        }

    }
