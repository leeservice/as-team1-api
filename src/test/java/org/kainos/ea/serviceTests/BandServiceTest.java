package org.kainos.ea.serviceTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.dao.BandDao;
import org.kainos.ea.exceptions.DatabaseConnectionException;
import org.kainos.ea.exceptions.FailedToGetBandException;
import org.kainos.ea.model.Band;
import org.kainos.ea.service.BandService;
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
public class BandServiceTest {
    DatabaseConnector databaseConnector = mock(DatabaseConnector.class);
    BandDao bandDao = mock(BandDao.class);
    BandService bandService = new BandService(bandDao, databaseConnector);
    Connection conn;

    @Test
    void getAllBands_shouldThrowFailedToGetBandException_whenDaoThrowsSQLException() throws SQLException, DatabaseConnectionException {
        when(databaseConnector.getConnection()).thenReturn(conn);
        when(bandDao.getAllBands(conn)).thenThrow(SQLException.class);
        assertThrows(FailedToGetBandException.class, () -> bandService.getAllBands());
    }

    @Test
    void getAllBands_shouldThrowFailedToGetBandException_whenDatabaseConnectorThrowsDatabaseConnectionException() throws SQLException, DatabaseConnectionException {
        when(databaseConnector.getConnection()).thenThrow(DatabaseConnectionException.class);
        assertThrows(FailedToGetBandException.class, () -> bandService.getAllBands());
    }

    @Test
    void getAllBands_shouldReturnBands_whenDaoReturnsBands() throws DatabaseConnectionException, SQLException, FailedToGetBandException {
        List<Band> bandList = new ArrayList<>();
        when(databaseConnector.getConnection()).thenReturn(conn);
        when(bandDao.getAllBands(conn)).thenReturn(bandList);
        List<Band> result = bandService.getAllBands();
        assertEquals(bandList, result);
    }
}
