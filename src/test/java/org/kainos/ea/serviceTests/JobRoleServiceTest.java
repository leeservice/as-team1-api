package org.kainos.ea.serviceTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.dao.JobRoleDao;
import org.kainos.ea.exceptions.DatabaseConnectionException;
import org.kainos.ea.exceptions.FailedToGetJobRoleException;
import org.kainos.ea.model.JobRoleRequest;
import org.kainos.ea.service.JobRoleService;
import org.kainos.ea.utility.DatabaseConnector;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class JobRoleServiceTest {
    JobRoleDao jobRoleDao = Mockito.mock(JobRoleDao.class);
    DatabaseConnector databaseConnector = Mockito.mock(DatabaseConnector.class);
    JobRoleService jobRoleService = new JobRoleService(jobRoleDao, databaseConnector);
    Connection conn;

    @Test
    void getJobRoles_shouldThrowFailedToGetJobRoleException_whenDaoThrowsSQLException() throws SQLException, DatabaseConnectionException {
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(jobRoleDao.getAllJobRoles(conn)).thenThrow(SQLException.class);

        assertThrows(FailedToGetJobRoleException.class,
                () -> jobRoleService.getAllJobRoles());
    }

    @Test
    void getJobRoles_shouldReturnJobRoles_whenDaoReturnsEmployees() throws DatabaseConnectionException, SQLException, FailedToGetJobRoleException {
        List<JobRoleRequest> jobRoleRequestList = new ArrayList<JobRoleRequest>();
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(jobRoleDao.getAllJobRoles(conn)).thenReturn(jobRoleRequestList);
        List<JobRoleRequest> result = jobRoleService.getAllJobRoles();
        assertEquals(jobRoleRequestList, result);
    }
}
