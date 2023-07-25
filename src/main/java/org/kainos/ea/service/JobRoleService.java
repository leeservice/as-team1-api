package org.kainos.ea.service;

import java.sql.SQLException;
import java.util.List;

import org.kainos.ea.dao.JobRoleDao;
import org.kainos.ea.exceptions.DatabaseConnectionException;
import org.kainos.ea.exceptions.FailedToCreateJobRoleException;
import org.kainos.ea.exceptions.FailedToGetJobRoleException;
import org.kainos.ea.exceptions.InvalidJobRoleException;
import org.kainos.ea.model.JobRole;
import org.kainos.ea.model.JobRolePostRequest;
import org.kainos.ea.utility.DatabaseConnector;
import org.kainos.ea.validator.JobRoleValidator;
import sun.tools.jps.Jps;

public class JobRoleService {

    public JobRoleDao jobRoleDao;
    public DatabaseConnector databaseConnector;

    public JobRoleService(JobRoleDao jobRoleDao, DatabaseConnector databaseConnector) {
        this.jobRoleDao = jobRoleDao;
        this.databaseConnector = databaseConnector;
    }

    public List<JobRole> getAllJobRoles() throws FailedToGetJobRoleException {
        List<JobRole> jobRoleList = null;
        try {
            jobRoleList = jobRoleDao.getAllJobRoles(databaseConnector.getConnection());
        } catch (SQLException | DatabaseConnectionException e) {
            System.err.println(e.getMessage());
            throw new FailedToGetJobRoleException();
        }
        return jobRoleList;
    }

    public int createJobRole(JobRolePostRequest jobRolePostRequest) throws FailedToCreateJobRoleException, InvalidJobRoleException {
        JobRoleValidator validator = new JobRoleValidator();
        try {
            if (!validator.isValidJobRole(jobRolePostRequest)) {
                throw new InvalidJobRoleException();
            }
            int id = jobRoleDao.addJobRole(jobRolePostRequest, databaseConnector.getConnection());
            if (id == -1) {
                throw new FailedToCreateJobRoleException();
            }
            return id;
        } catch (SQLException | DatabaseConnectionException e) {
            System.err.println(e.getMessage());
            throw new FailedToCreateJobRoleException();
        }
    }
}
