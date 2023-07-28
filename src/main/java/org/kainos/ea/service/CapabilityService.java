package org.kainos.ea.service;

import org.kainos.ea.dao.CapabilityDao;
import org.kainos.ea.exceptions.DatabaseConnectionException;
import org.kainos.ea.exceptions.FailedToGetCapabilityException;
import org.kainos.ea.model.CapabilityResponse;
import org.kainos.ea.utility.DatabaseConnector;

import java.sql.SQLException;
import java.util.List;

public class CapabilityService {
    public CapabilityDao capabilityDao;
    public DatabaseConnector databaseConnector;

    public CapabilityService(CapabilityDao capabilityDao, DatabaseConnector databaseConnector) {
        this.capabilityDao = capabilityDao;
        this.databaseConnector = databaseConnector;
    }

    public List<CapabilityResponse> getAllCapabilities() throws FailedToGetCapabilityException {
        List<CapabilityResponse> capabilityResponseList = null;
        try {
            return capabilityDao.getAllCapabilities(databaseConnector.getConnection());
        } catch (SQLException | DatabaseConnectionException e) {
            System.err.println(e.getMessage());
            throw new FailedToGetCapabilityException();
        }
    }
}
