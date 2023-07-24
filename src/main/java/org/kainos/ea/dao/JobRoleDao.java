package org.kainos.ea.dao;

import org.kainos.ea.model.JobRoleRequest;
import org.kainos.ea.utility.DatabaseConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JobRoleDao {
    private DatabaseConnector databaseConnector = new DatabaseConnector();

    public List<JobRoleRequest> getAllJobRoles(Connection c) throws SQLException {
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT Job_Roles.id AS 'ID', Job_Roles.`name` AS 'Name', description AS 'Specification Description'," +
                " level_of_band AS 'Band Level', Job_Roles.capability_id AS 'Capability Id'" +
                " FROM Job_Roles" +
                " INNER JOIN Banding ON Job_Roles.band_id = Banding.id");

        List<JobRoleRequest> jobRoleList = new ArrayList<>();

        while(rs.next()) {
            JobRoleRequest jobRoleRequest = new JobRoleRequest(
                    rs.getInt("ID"),
                    rs.getString("Name"),
                    rs.getString("Specification Description"),
                    rs.getString("Band Level"),
                    rs.getInt("Capability Id")
            );
            jobRoleList.add(jobRoleRequest);
        }
        return jobRoleList;
    }
}
