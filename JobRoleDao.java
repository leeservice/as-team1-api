import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JobRoleDao {
    private DatabaseConnector databaseConnector = new DatabaseConnector();

    public List<JobRole> getAllJobRoles() throws SQLException {
        Connection c = databaseConnector.getConnection();
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT id, name, description, band_id  FROM Job_Roles;");

        List<JobRole> jobRoleList = new ArrayList<>();

        while(rs.next()) {
            JobRole jobRole = new JobRole(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getInt("band_id")
            );
            jobRoleList.add(jobRole);
        }
        return jobRoleList;
    }
}
