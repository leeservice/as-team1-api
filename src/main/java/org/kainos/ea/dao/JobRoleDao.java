package org.kainos.ea.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.kainos.ea.model.JobRole;
import org.kainos.ea.model.JobRolePostRequest;

public class JobRoleDao {
    public List<JobRole> getAllJobRoles(Connection c) throws SQLException {
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT Job_Roles.id AS 'ID', Job_Roles.`name` AS 'Name'" + " FROM Job_Roles");

        List<JobRole> jobRoleList = new ArrayList<>();

        while (rs.next()) {
            JobRole jobRole = new JobRole(rs.getInt("ID"), rs.getString("Name"));
            jobRoleList.add(jobRole);
        }
        return jobRoleList;
    }

    public int addJobRole(JobRolePostRequest jobRolePostRequest, Connection c) throws SQLException {
        String statement = "INSERT INTO Job_Roles(name, specification_description, url_link, capability_id, band_id" + " VALUES(?,?,?,?,?)";
        PreparedStatement st = c.prepareStatement(statement, Statement.RETURN_GENERATED_KEYS);
        st.setString(1, jobRolePostRequest.getName());
        st.setString(2, jobRolePostRequest.getSpecificationDesc());
        st.setString(3, jobRolePostRequest.getUrl());
        st.setInt(4, jobRolePostRequest.getCapability_id());
        st.setInt(5, jobRolePostRequest.getBand_id());

        st.executeUpdate();
        ResultSet rs = st.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }
}
