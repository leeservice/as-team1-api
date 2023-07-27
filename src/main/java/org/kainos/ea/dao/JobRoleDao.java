package org.kainos.ea.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.kainos.ea.model.JobRoleResponse;

public class JobRoleDao {
    public List<JobRoleResponse> getAllJobRoles(Connection c) throws SQLException {
        Statement st = c.createStatement();

        ResultSet rs =
            st.executeQuery(
                "SELECT Job_Roles.id AS 'ID', Job_Roles.`name` AS 'Name',Capability.id AS"
                    + " 'Capability ID', Capability.`name` AS 'Capability Name',"
                    + " Job_Roles.specification_description AS 'Job Description',"
                    + " Job_Roles.url_link AS 'URL' FROM Job_Roles INNER JOIN Capability"
                    + " ON Job_Roles.capability_id = Capability.id;");

        List<JobRoleResponse> jobRoleResponseList = new ArrayList<>();

        while (rs.next()) {
            JobRoleResponse jobRoleResponse =
                new JobRoleResponse(
                    rs.getInt("ID"),
                    rs.getString("Name"),
                    rs.getString("Capability Name"),
                    rs.getString("URL"),
                    rs.getString("Job Description"));
            jobRoleResponseList.add(jobRoleResponse);
        }
        return jobRoleResponseList;
    }
}
