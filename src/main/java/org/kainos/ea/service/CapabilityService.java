package org.kainos.ea.service;

import org.kainos.ea.dao.CapabilityDao;
import org.kainos.ea.exceptions.DatabaseConnectionException;
import org.kainos.ea.exceptions.FailedToGetCapabilityException;
import org.kainos.ea.model.Capability;
import org.kainos.ea.utility.DatabaseConnector;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.List;

public class CapabilityService {
    public CapabilityDao capabilityDao;
    public DatabaseConnector databaseConnector;

    public CapabilityService(CapabilityDao capabilityDao, DatabaseConnector databaseConnector) {
        this.capabilityDao = capabilityDao;
        this.databaseConnector = databaseConnector;
    }

    public List<Capability> getAllCapabilities() throws FailedToGetCapabilityException {
        List<Capability> capabilityList = null;
        try {
            capabilityList = capabilityDao.getAllCapabilities(databaseConnector.getConnection());
        } catch (SQLException | DatabaseConnectionException e) {
            System.err.println(e.getMessage());
            throw new FailedToGetCapabilityException();
        }
        return capabilityList;
    }
}
