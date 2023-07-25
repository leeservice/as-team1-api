package org.kainos.ea.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.kainos.ea.model.JobRoleGetRequest;

public class JobRoleDao {
    public List<JobRoleGetRequest> getAllJobRoles(Connection c) throws SQLException {
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT Job_Roles.id AS 'ID', Job_Roles.`name` AS 'Name', Capability.id AS 'Capability ID', Capability.`name` AS 'Capability Name'" +
                " FROM Job_Roles" +
                " INNER JOIN Capability ON Job_Roles.capability_id = Capability.id;");

        List<JobRoleGetRequest> jobRoleRequestList = new ArrayList<>();

        while (rs.next()) {
            JobRoleGetRequest jobRoleGetRequest = new JobRoleGetRequest(rs.getInt("ID"), rs.getString("Name"), rs.getString("Capability Name"));
            jobRoleRequestList.add(jobRoleGetRequest);
        }
        return jobRoleRequestList;
    }
}
