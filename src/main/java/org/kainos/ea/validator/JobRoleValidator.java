package org.kainos.ea.validator;

import org.kainos.ea.model.JobRoleRequest;

public class JobRoleValidator {
    public boolean isValidJobRole(JobRoleRequest jobRoleRequest) {
        if (jobRoleRequest.getName().length() > 50) {
            System.out.println("Name too long");
            return false;
        }
        if (jobRoleRequest.getName().trim() == "") {
            System.out.println("Name is empty");
            return false;
        }
        if (jobRoleRequest.getUrl().length() > 500) {
            System.out.println("URL too long");
            return false;
        }
        if (jobRoleRequest.getCapabilityId() > 50 || jobRoleRequest.getCapabilityId() < 1) {
            System.out.println("Capability ID out of range");
            return false;
        }
        if (jobRoleRequest.getBandId() > 50 || jobRoleRequest.getBandId() < 1) {
            System.out.println("Band ID out of range");
            return false;
        }
        return true;
    }
}
