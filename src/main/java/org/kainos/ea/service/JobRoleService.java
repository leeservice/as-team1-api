package org.kainos.ea.service;

import org.kainos.ea.dao.JobRoleDao;
import org.kainos.ea.exceptions.DatabaseConnectionException;
import org.kainos.ea.exceptions.FailedToGetJobRoleException;
import org.kainos.ea.model.JobRoleResponse;
import org.kainos.ea.utility.DatabaseConnector;

import java.sql.SQLException;
import java.util.List;

public class JobRoleService {

    public JobRoleDao jobRoleDao;
    public DatabaseConnector databaseConnector;

        public JobRoleService(JobRoleDao jobRoleDao, DatabaseConnector databaseConnector) {
            this.jobRoleDao = jobRoleDao;
            this.databaseConnector = databaseConnector;
        }
    public List<JobRoleResponse> getAllJobRoles() throws FailedToGetJobRoleException {
        List<JobRoleResponse> jobRoleList = null;
        try {
            jobRoleList = jobRoleDao.getAllJobRoles(databaseConnector.getConnection());
        } catch (SQLException | DatabaseConnectionException e) {
            System.err.println(e.getMessage());
            throw new FailedToGetJobRoleException();
        }
    }

