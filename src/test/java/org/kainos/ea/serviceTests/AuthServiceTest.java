package org.kainos.ea.serviceTests;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.exceptions.DatabaseConnectionException;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

    JobRoleService jobRoleService = new JobRoleService(jobRoleDao, databaseConnector);

    @Test
    void createJobRole_shouldThrowFailedToCreateJobRoleException_whenDaoThrowsSQLException() throws DatabaseConnectionException, SQLException {
        when(databaseConnector.getConnection()).thenReturn(conn);
        when(jobRoleDao.createJobRole(jobRoleRequest, conn)).thenThrow(SQLException.class);
        assertThrows(FailedToCreateJobRoleException.class, () -> jobRoleService.createJobRole(jobRoleRequest));
    }
}
