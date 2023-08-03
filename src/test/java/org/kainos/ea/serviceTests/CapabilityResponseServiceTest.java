package org.kainos.ea.serviceTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.dao.CapabilityDao;
import org.kainos.ea.exceptions.DatabaseConnectionException;
import org.kainos.ea.exceptions.FailedToGetCapabilityException;
import org.kainos.ea.model.CapabilityResponse;
import org.kainos.ea.service.CapabilityService;
import org.kainos.ea.utility.DatabaseConnector;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CapabilityResponseServiceTest {
    DatabaseConnector databaseConnector = mock(DatabaseConnector.class);
    CapabilityDao capabilityDao = mock(CapabilityDao.class);
    CapabilityService capabilityService = new CapabilityService(capabilityDao, databaseConnector);
    Connection conn;

    @Test
    void getAllCapabilities_shouldThrowFailedToGetCapabilityException_whenDaoThrowsSQLException() throws SQLException, DatabaseConnectionException {
        when(databaseConnector.getConnection()).thenReturn(conn);
        when(capabilityDao.getAllCapabilities(conn)).thenThrow(SQLException.class);
        assertThrows(FailedToGetCapabilityException.class, () -> capabilityService.getAllCapabilities());
    }

    @Test
    void getAllCapabilities_shouldThrowFailedToGetCapabilityException_whenDatabaseConnectorThrowsDatabaseConnectionException() throws SQLException, DatabaseConnectionException {
        when(databaseConnector.getConnection()).thenThrow(DatabaseConnectionException.class);
        assertThrows(FailedToGetCapabilityException.class, () -> capabilityService.getAllCapabilities());
    }

    @Test
    void getAllCapabilities_shouldReturnCapabilities_whenDaoReturnsCapabilities() throws DatabaseConnectionException, SQLException, FailedToGetCapabilityException {
        List<CapabilityResponse> capabilityResponseList = new ArrayList<>();
        when(databaseConnector.getConnection()).thenReturn(conn);
        when(capabilityDao.getAllCapabilities(conn)).thenReturn(capabilityResponseList);
        List<CapabilityResponse> result = capabilityService.getAllCapabilities();
        assertEquals(capabilityResponseList, result);
    }
}
