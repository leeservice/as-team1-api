package org.kainos.ea.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.kainos.ea.model.JobRoleRequest;
import org.kainos.ea.model.JobRoleResponse;

public class JobRoleDao {
    public List<JobRoleResponse> getAllJobRoles(Connection c) throws SQLException {
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT Job_Roles.id AS 'ID', Job_Roles.`name` AS 'Name', Capability.id AS 'Capability ID', Capability.`name` AS 'Capability Name'" + " FROM Job_Roles" + " INNER JOIN Capability ON Job_Roles.capability_id = Capability.id;");

        List<JobRoleResponse> jobRoleResponseList = new ArrayList<>();

        while (rs.next()) {
            JobRoleResponse jobRoleResponse = new JobRoleResponse(rs.getInt("ID"), rs.getString("Name"), rs.getString("Capability Name"));
            jobRoleResponseList.add(jobRoleResponse);
        }
        return jobRoleResponseList;
    }

    public int createJobRole(JobRoleRequest jobRoleRequest, Connection c) throws SQLException {
        String statement = "INSERT INTO Job_Roles(`name`, specification_description, url_link, capability_id, band_id)" + " VALUES(?,?,?,?,?)";
        PreparedStatement st = c.prepareStatement(statement, Statement.RETURN_GENERATED_KEYS);
        st.setString(1, jobRoleRequest.getName());
        st.setString(2, jobRoleRequest.getSpecificationDesc());
        st.setString(3, jobRoleRequest.getUrl());
        st.setInt(4, jobRoleRequest.getCapability_id());
        st.setInt(5, jobRoleRequest.getBand_id());

        st.executeUpdate();
        ResultSet rs = st.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }
}
