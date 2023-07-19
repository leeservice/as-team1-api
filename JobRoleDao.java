import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JobRoleDao {
    private DatabaseConnector databaseConnector = new DatabaseConnector();

    public List<JobRoleRequest> getAllJobRoles() throws SQLException {
        Connection c = databaseConnector.getConnection();
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT Job_Roles.`name` AS 'Name', description AS 'Specification Description'," + 
                " level_of_band AS 'Band Level', Capability.`name` AS 'Capability" +
                " FROM Job_Roles" +
                " INNER JOIN Banding ON Job_Roles.band_id = Banding.id" +
                " INNER JOIN Capability ON Job_Roles.capability_id = Capability.id;");

        List<JobRoleRequest> jobRoleList = new ArrayList<>();

        while(rs.next()) {
            JobRoleRequest jobRoleRequest = new JobRoleRequest(
                    rs.getString("Name"),
                    rs.getString("Specification Description"),
                    rs.getString("Band Level"),
                    rs.getString("Capability")
            );
            jobRoleList.add(jobRoleRequest);
        }
        return jobRoleList;
    }
}
