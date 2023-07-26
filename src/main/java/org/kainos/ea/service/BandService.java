package org.kainos.ea.service;

import org.kainos.ea.dao.BandDao;
import org.kainos.ea.exceptions.DatabaseConnectionException;
import org.kainos.ea.exceptions.FailedToGetBandException;
import org.kainos.ea.model.Band;
import org.kainos.ea.utility.DatabaseConnector;

import java.sql.SQLException;
import java.util.List;

public class BandService {
    public BandDao bandDao;
    public DatabaseConnector databaseConnector;

    public BandService(BandDao bandDao, DatabaseConnector databaseConnector) {
        this.bandDao = bandDao;
        this.databaseConnector = databaseConnector;
    }

    public List<Band> getAllBands() throws FailedToGetBandException {
        List<Band> bandList = null;
        try {
            bandList = bandDao.getAllBands(databaseConnector.getConnection());
        } catch (SQLException | DatabaseConnectionException e) {
            System.err.println(e.getMessage());
            throw new FailedToGetBandException();
        }
        return bandList;
    }
}
