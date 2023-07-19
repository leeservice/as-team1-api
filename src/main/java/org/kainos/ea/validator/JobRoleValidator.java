package org.kainos.ea.validator;

import org.kainos.ea.model.JobRole;

public class JobRoleValidator {
    public boolean isValidJobRole(JobRole jobRole) {
        if (jobRole.getName().length() > 50) {
            return false;
        }
        return true;
    }
}
