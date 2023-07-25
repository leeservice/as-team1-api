package org.kainos.ea.validator;

import org.kainos.ea.model.JobRole;
import org.kainos.ea.model.JobRolePostRequest;

public class JobRoleValidator {
    public boolean isValidJobRole(JobRolePostRequest jobRolePostRequest) {
        if (jobRolePostRequest.getName().length() > 50) {
            return false;
        }
        return true;
    }
}
