package org.kainos.ea.serviceTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.dao.JobRoleDao;
import org.kainos.ea.exceptions.DatabaseConnectionException;
import org.kainos.ea.exceptions.FailedToGetJobRoleException;
import org.kainos.ea.model.JobRole;
import org.kainos.ea.service.JobRoleService;
import org.kainos.ea.utility.DatabaseConnector;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class JobRoleServiceTest {
    JobRoleDao jobRoleDao = mock(JobRoleDao.class);
    DatabaseConnector databaseConnector = mock(DatabaseConnector.class);
    JobRoleService jobRoleService = new JobRoleService(jobRoleDao, databaseConnector);
    Connection conn;

    @Test
    void getJobRoles_shouldThrowFailedToGetJobRoleException_whenDaoThrowsSQLException() throws SQLException, DatabaseConnectionException {
        when(databaseConnector.getConnection()).thenReturn(conn);
        when(jobRoleDao.getAllJobRoles(conn)).thenThrow(SQLException.class);

        assertThrows(FailedToGetJobRoleException.class, () -> jobRoleService.getAllJobRoles());
    }

    @Test
    void getJobRoles_shouldThrowFailedToGetJobRoleException_whenDaoThrowsDatabaseConnectionException() throws SQLException, DatabaseConnectionException {
        when(databaseConnector.getConnection()).thenReturn(conn);
        given(jobRoleDao.getAllJobRoles(conn)).willAnswer(invocationOnMock -> {
            throw new DatabaseConnectionException();
        });
        assertThrows(FailedToGetJobRoleException.class, () -> jobRoleService.getAllJobRoles());
    }

    @Test
    void getJobRoles_shouldReturnJobRoles_whenDaoReturnsJobRoles() throws DatabaseConnectionException, SQLException, FailedToGetJobRoleException {
        List<JobRole> jobRole = new ArrayList<JobRole>();
        when(databaseConnector.getConnection()).thenReturn(conn);
        when(jobRoleDao.getAllJobRoles(conn)).thenReturn(jobRole);
        List<JobRole> result = jobRoleService.getAllJobRoles();
        assertEquals(jobRole, result);
    }
}
