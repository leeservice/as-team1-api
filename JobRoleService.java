import java.sql.SQLException;
import java.util.List;

public class JobRoleService {
    private JobRoleDao jobRoleDao = new JobRoleDao();

    public List<JobRole> getAllJobRoles() throws FailedToGetJobRoleException {
        List<JobRole> jobRoleList = null;
        try {
            jobRoleList = jobRoleDao.getAllJobRoles();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToGetJobRoleException();
        }
        return jobRoleList;
    }
}
