package org.kainos.ea.service;

import org.kainos.ea.dao.JobRoleDao;
import org.kainos.ea.exceptions.DatabaseConnectionException;
import org.kainos.ea.exceptions.FailedToGetJobRoleException;
import org.kainos.ea.exceptions.JobRoleDoesNotExistException;
import org.kainos.ea.model.JobRole;
import org.kainos.ea.model.JobRoleRequest;
import org.kainos.ea.utility.DatabaseConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class JobRoleService {
    public JobRoleDao jobRoleDao = new JobRoleDao();
    public DatabaseConnector databaseConnector;

    public JobRoleService(JobRoleDao jobRoleDao, DatabaseConnector databaseConnector) {
        this.jobRoleDao = jobRoleDao;
        this.databaseConnector = databaseConnector;
    }

    public List<JobRoleRequest> getAllJobRoles() throws FailedToGetJobRoleException {
        List<JobRoleRequest> jobRoleList = null;
        try {
            jobRoleList = jobRoleDao.getAllJobRoles(databaseConnector.getConnection());
        } catch (SQLException | DatabaseConnectionException e) {
            System.err.println(e.getMessage());
            throw new FailedToGetJobRoleException();
        }
        return jobRoleList;
    }
    public JobRole deleteJob(int id) throws JobRoleDoesNotExistException, FailedToGetJobRoleException {
        JobRole jobToDelete = null;
        try
        {
            jobToDelete = jobRoleDao.getJobRoleByIdO(id, databaseConnector.getConnection());
            if(jobToDelete == null)
            {
                throw new JobRoleDoesNotExistException();
            }
            jobRoleDao.deleteJob(id, databaseConnector.getConnection());
        } catch (SQLException | DatabaseConnectionException e) {
            System.err.println(e.getMessage());
            throw new FailedToGetJobRoleException();
        }
        return jobToDelete;
    }
}
