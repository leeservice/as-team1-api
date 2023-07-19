public class JobRoleValidator {
    public boolean isValidJobRole(JobRole jobRole) {
        if (jobRole.getName().length() > 50) {
            return false;
        }

        if (jobRole.getSpecificationDesc().length())
    }
}
