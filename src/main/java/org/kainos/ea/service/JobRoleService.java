package org.kainos.ea.service;

import java.sql.SQLException;
import java.util.List;

import org.kainos.ea.dao.JobRoleDao;
import org.kainos.ea.exceptions.*;
import org.kainos.ea.model.JobRoleRequest;
import org.kainos.ea.model.JobRoleResponse;
import org.kainos.ea.utility.DatabaseConnector;
import org.kainos.ea.validator.JobRoleValidator;

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
        return jobRoleList;
    }

    public int createJobRole(JobRoleRequest jobRoleRequest) throws FailedToCreateJobRoleException, InvalidJobRoleException {
        JobRoleValidator validator = new JobRoleValidator();
        try {
            if (!validator.isValidJobRole(jobRoleRequest)) {
                throw new InvalidJobRoleException();
            }
            int id = jobRoleDao.createJobRole(jobRoleRequest, databaseConnector.getConnection());
            if (id == -1) {
                throw new FailedToCreateJobRoleException();
            }
            return id;
        } catch (SQLException | DatabaseConnectionException e) {
            System.err.println(e.getMessage());
            throw new FailedToCreateJobRoleException();
        }
    }
    public  int updateJobRole(int id, JobRoleRequest jobRoleRequest) throws FailedToCreateJobRoleException, InvalidJobRoleException, JobRoleDoesNotExistException {
        JobRoleValidator validator = new JobRoleValidator();
        try {
            if (!validator.isValidJobRole(jobRoleRequest)) {
                throw new InvalidJobRoleException();
            }
            jobRoleDao.updateJobRole(id, jobRoleRequest, databaseConnector.getConnection());
            return id;
        } catch (SQLException | DatabaseConnectionException e) {
            System.err.println(e.getMessage());
            throw new FailedToCreateJobRoleException();
        }
    }
}
