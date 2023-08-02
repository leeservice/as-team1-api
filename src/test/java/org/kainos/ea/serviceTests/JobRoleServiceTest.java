package org.kainos.ea.serviceTests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import org.kainos.ea.exceptions.JobRoleDoesNotExistException;
import org.kainos.ea.model.JobRole;
import org.kainos.ea.exceptions.*;
import org.kainos.ea.model.JobRoleRequest;
import org.kainos.ea.model.JobRoleResponse;
import org.kainos.ea.service.JobRoleService;
import org.kainos.ea.utility.DatabaseConnector;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
public class JobRoleServiceTest {
    JobRoleDao jobRoleDao = mock(JobRoleDao.class);
    DatabaseConnector databaseConnector = mock(DatabaseConnector.class);
    JobRoleService jobRoleService = new JobRoleService(jobRoleDao, databaseConnector);
    Connection conn;
    JobRoleRequest jobRoleRequest = new JobRoleRequest("Test Job Role", "This is a description.", 1, 1, "https://kainos.com");
    @Test
    void getAllJobRoles_shouldThrowFailedToGetJobRoleException_whenDaoThrowsSQLException() throws SQLException, DatabaseConnectionException {
        when(databaseConnector.getConnection()).thenReturn(conn);
        when(jobRoleDao.getAllJobRoles(conn)).thenThrow(SQLException.class);
        assertThrows(FailedToGetJobRoleException.class, () -> jobRoleService.getAllJobRoles());
    }

    @Test
    void getAllJobRoles_shouldThrowFailedToGetJobRoleException_whenDatabaseConnectorThrowsDatabaseConnectionException() throws SQLException, DatabaseConnectionException {
        when(databaseConnector.getConnection()).thenThrow(DatabaseConnectionException.class);
        assertThrows(FailedToGetJobRoleException.class, () -> jobRoleService.getAllJobRoles());
    }

    @Test
    void getAllJobRoles_shouldReturnJobRoles_whenDaoReturnsJobRoles() throws DatabaseConnectionException, SQLException, FailedToGetJobRoleException {
        List<JobRoleResponse> jobRoleResponseList = new ArrayList<>();
        when(databaseConnector.getConnection()).thenReturn(conn);
        when(jobRoleDao.getAllJobRoles(conn)).thenReturn(jobRoleResponseList);
        List<JobRoleResponse> result = jobRoleService.getAllJobRoles();
        assertEquals(jobRoleResponseList, result);

    }

    @Test
    void deleteJobRole_whenDaoReturnsNull() throws  SQLException, DatabaseConnectionException {
        Mockito.when(databaseConnector.getConnection()).thenReturn(null);
        Mockito.when(jobRoleDao.getJobRoleByIdO(0, conn)).thenReturn(null);
        assertThrows(JobRoleDoesNotExistException.class, () -> jobRoleService.deleteJob(0));
    }
    @Test
    void deleteJobRole_shouldThrowFailedToGetJobRoleException_whenDaoThrowsSQLException() throws  SQLException, DatabaseConnectionException {
        when(databaseConnector.getConnection()).thenReturn(conn);

        when(jobRoleDao.getJobRoleByIdO(1,conn)).thenThrow(SQLException.class);

        assertThrows(FailedToGetJobRoleException.class, () ->jobRoleService.deleteJob(1));
    }
    @Test
    void deleteJobRole_shouldReturnJobRoles_whenDaoReturnsJobRoles() throws  SQLException, DatabaseConnectionException {

        JobRole jobRole = new JobRole(1, "great", "Wow","https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Forms/AllItems.aspx?id=%2Fpeople%2FJob%20Specifications%2FEngineering%2FJob%20Profile%20%2D%20Technology%20Leader%2Epdf&parent=%2Fpeople%2FJob%20Specifications%2FEngineering&p=true&ga=",1,1);
        when(databaseConnector.getConnection()).thenReturn(conn);
        when(jobRoleDao.getJobRoleByIdO(1,conn)).thenReturn(jobRole);
        JobRole result = jobRoleDao.getJobRoleByIdO(1,conn);
        assertEquals(jobRole, result);
    }
    @Test
    void createJobRole_shouldReturnId_whenDaoReturnsId() throws DatabaseConnectionException, SQLException, InvalidJobRoleException, FailedToCreateJobRoleException {
        int expectedResult = 1;
        when(databaseConnector.getConnection()).thenReturn(conn);
        when(jobRoleDao.createJobRole(jobRoleRequest, conn)).thenReturn(expectedResult);
        int result = jobRoleService.createJobRole(jobRoleRequest);
        assertEquals(expectedResult, result);
    }

    @Test
    void createJobRole_shouldThrowFailedToCreateJobRoleException_whenDaoThrowsSQLException() throws DatabaseConnectionException, SQLException {
        when(databaseConnector.getConnection()).thenReturn(conn);
        when(jobRoleDao.createJobRole(jobRoleRequest, conn)).thenThrow(SQLException.class);
        assertThrows(FailedToCreateJobRoleException.class, () -> jobRoleService.createJobRole(jobRoleRequest));
    }

    @Test
    void createJobRole_shouldThrowFailedToCreateJobRoleException_whenDatabaseConnectorThrowsDatabaseConnectionException() throws DatabaseConnectionException, SQLException {
        when(databaseConnector.getConnection()).thenThrow(DatabaseConnectionException.class);
        assertThrows(FailedToCreateJobRoleException.class, () -> jobRoleService.createJobRole(jobRoleRequest));
    }
}
