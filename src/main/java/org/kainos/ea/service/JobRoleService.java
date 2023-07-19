package org.kainos.ea.service;

import org.kainos.ea.dao.JobRoleDao;
import org.kainos.ea.exceptions.FailedToGetJobRoleException;
import org.kainos.ea.model.JobRoleRequest;

import java.sql.SQLException;
import java.util.List;

public class JobRoleService {
    private JobRoleDao jobRoleDao = new JobRoleDao();

    public List<JobRoleRequest> getAllJobRoles() throws FailedToGetJobRoleException {
        List<JobRoleRequest> jobRoleList = null;
        try {
            jobRoleList = jobRoleDao.getAllJobRoles();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToGetJobRoleException();
        }
        return jobRoleList;
    }
}
