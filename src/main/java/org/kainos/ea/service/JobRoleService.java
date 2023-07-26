package org.kainos.ea.service;

import java.sql.SQLException;
import java.util.List;

import org.kainos.ea.dao.JobRoleDao;
import org.kainos.ea.exceptions.DatabaseConnectionException;
import org.kainos.ea.exceptions.FailedToCreateJobRoleException;
import org.kainos.ea.exceptions.FailedToGetJobRoleException;
import org.kainos.ea.exceptions.InvalidJobRoleException;
import org.kainos.ea.model.JobRole;
import org.kainos.ea.model.JobRoleRequest;
import org.kainos.ea.utility.DatabaseConnector;
import org.kainos.ea.validator.JobRoleValidator;

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

    public int createJobRole(JobRoleRequest jobRoleRequest) throws FailedToCreateJobRoleException, InvalidJobRoleException {
        JobRoleValidator validator = new JobRoleValidator();
        try {
            if (!validator.isValidJobRole(jobRoleRequest)) {
                System.out.println(validator.isValidJobRole(jobRoleRequest));
                throw new InvalidJobRoleException();
            }
            int id = jobRoleDao.addJobRole(jobRoleRequest, databaseConnector.getConnection());
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
