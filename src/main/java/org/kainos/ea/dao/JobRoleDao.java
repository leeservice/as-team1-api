package org.kainos.ea.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.kainos.ea.model.JobRole;

public class JobRoleDao {
    public List<JobRole> getAllJobRoles(Connection c) throws SQLException {
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT Job_Roles.id AS 'ID', Job_Roles.`name` AS 'Name'"+
                " FROM Job_Roles");

        List<JobRole> jobRoleList = new ArrayList<>();

        while(rs.next()) {
            JobRole jobRole = new JobRole(
                    rs.getInt("ID"),
                    rs.getString("Name")
            );
            jobRoleList.add(jobRole);
        }
        return jobRoleList;
    }
}
