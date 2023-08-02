package org.kainos.ea.dao;
import org.kainos.ea.exceptions.DatabaseConnectionException;
import org.kainos.ea.model.JobRole;
import org.kainos.ea.model.JobRoleResponse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.kainos.ea.model.JobRoleRequest;
public class JobRoleDao {


    public List<JobRoleResponse> getAllJobRoles(Connection c) throws SQLException {
        Statement st = c.createStatement();

        ResultSet rs =
                st.executeQuery(
                        "SELECT Job_Roles.id AS 'ID', Job_Roles.`name` AS 'Name',Capability.id AS"
                                + " 'Capability ID', "
                                + " Job_Roles.specification_description AS 'Job Description',"
                                + " Job_Roles.url_link AS 'URL', Banding.level_of_band as 'Band Level',  Capability.`name` AS 'Capability Name' FROM Job_Roles INNER JOIN Capability ON Job_Roles.capability_id = Capability.id "
                                + " INNER JOIN Banding ON Job_Roles.BAND_ID = Banding.id;");

        List<JobRoleResponse> jobRoleList = new ArrayList();

        while (rs.next()) {
            JobRoleResponse jobRoleResponse =
                    new JobRoleResponse(
                            rs.getInt("ID"),
                            rs.getString("Name"),
                            rs.getString("Job Description"),
                            rs.getString("URL"),
                            rs.getString("Capability Name"),
                            rs.getString("Band Level"));
            jobRoleList.add(jobRoleResponse);
        }
        return jobRoleList;
    }

    public void deleteJob(int id, Connection c) throws SQLException, DatabaseConnectionException {
        String deleteStatement = "DELETE FROM Job_Roles Where Job_Roles.id = ?";
        PreparedStatement st = c.prepareStatement(deleteStatement);
        st.setInt(1, id);
        st.executeUpdate();
    }

    public JobRole getJobRoleByIdO(int id, Connection c) throws SQLException {
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT Job_Roles.id AS 'ID', Job_Roles.`name` AS 'Name', specification_description AS 'Specification Description'," +
                "url_link AS 'URL Link'," +
                " Job_Roles.band_id AS 'Band Id', Job_Roles.capability_id AS 'Capability Id'" +
                " FROM Job_Roles where ID = " + id + ";");
        while (rs.next()) {
            return new JobRole(
                    rs.getInt("ID"),
                    rs.getString("Name"),
                    rs.getString("Specification Description"),
                    rs.getString("URL Link"),
                    rs.getInt("Band Id"),
                    rs.getInt("Capability Id")
            );
        }
        return null;
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
