package org.kainos.ea.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.kainos.ea.model.JobRoleRequest;
import org.kainos.ea.model.JobRoleResponse;
public class JobRoleDao {
    public List<JobRoleResponse> getAllJobRoles(Connection c) throws SQLException {
        Statement st = c.createStatement();

        ResultSet rs =
                st.executeQuery(
                        "SELECT Job_Roles.id AS 'ID', Job_Roles.`name` AS 'Name',CapabilityResponse.id AS"
                            + " 'CapabilityResponse ID', CapabilityResponse.`name` AS 'CapabilityResponse Name',"
                            + " Job_Roles.specification_description AS 'Job Description',"
                            + " Job_Roles.url_link AS 'URL' FROM Job_Roles INNER JOIN CapabilityResponse"
                            + " ON Job_Roles.capability_id = CapabilityResponse.id;");
        List<JobRoleResponse> jobRoleResponseList = new ArrayList<>();

        while (rs.next()) {
            JobRoleResponse jobRoleResponse =
                    new JobRoleResponse(
                            rs.getInt("ID"),
                            rs.getString("Name"),
                            rs.getString("CapabilityResponse Name"),
                            rs.getString("URL"),
                            rs.getString("Job Description"));
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
        st.setInt(4, jobRoleRequest.getCapabilityId());
        st.setInt(5, jobRoleRequest.getBandId());

        st.executeUpdate();
        ResultSet rs = st.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }
}
