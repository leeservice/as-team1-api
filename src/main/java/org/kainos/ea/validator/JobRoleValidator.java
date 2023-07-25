package org.kainos.ea.validator;

import org.kainos.ea.model.JobRoleRequest;

public class JobRoleValidator {
    public boolean isValidJobRole(JobRoleRequest jobRoleRequest) {
        if (jobRoleRequest.getName().length() > 50) {
            return false;
        }
        return true;
    }
}
