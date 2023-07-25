package org.kainos.ea.dao;

import org.kainos.ea.exceptions.DatabaseConnectionException;
import org.kainos.ea.model.JobRole;
import org.kainos.ea.model.JobRoleRequest;
import org.kainos.ea.utility.DatabaseConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobRoleDao {


    public List<JobRoleRequest> getAllJobRoles(Connection c) throws SQLException {
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT Job_Roles.id AS 'ID', Job_Roles.`name` AS 'Name', specification_description AS 'Specification Description'," +
                "url_link AS 'URL Link'," +
                " level_of_band AS 'Band Level', Capability.`name` AS 'Capability '" +
                " FROM Job_Roles" +
                " INNER JOIN Banding ON Job_Roles.band_id = Banding.id"
                +
                " INNER JOIN Capability ON Job_Roles.capability_id = Capability.id");

        List<JobRoleRequest> jobRoleList = new ArrayList<>();

        while(rs.next()) {
            JobRoleRequest jobRoleRequest = new JobRoleRequest(
                    rs.getInt("ID"),
                    rs.getString("Name"),
                    rs.getString("Specification Description"),
                    rs.getString("URL Link"),
                    rs.getString("Band Level"),
                    rs.getString("Capability")
            );
            jobRoleList.add(jobRoleRequest);
        }
        return jobRoleList;
    }
    public  void deleteJob(int id, Connection c) throws SQLException, DatabaseConnectionException {
        String deleteStatement = "DELETE FROM Job_Roles Where Job_Roles.id = ?";
        PreparedStatement st = c.prepareStatement(deleteStatement);
        st.setInt(1,id);
        st.executeUpdate();
    }
    public JobRole getJobRoleByIdO(int id, Connection c) throws SQLException {
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT Job_Roles.id AS 'ID', Job_Roles.`name` AS 'Name', specification_description AS 'Specification Description'," +
                "url_link AS 'URL Link'," +
                " Job_Roles.band_id AS 'Band Id', Job_Roles.capability_id AS 'Capability Id'" +
                " FROM Job_Roles where ID = "+ id +";");
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
}
