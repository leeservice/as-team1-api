package org.kainos.ea.dao;
import org.kainos.ea.model.JobRoleResponse;

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

        ResultSet rs = st.executeQuery("SELECT Job_Roles.id AS 'ID', Job_Roles.`name` AS 'Name', specification_description AS 'Specification Description'," +
                "url_link AS 'URL Link'," +
                " level_of_band AS 'Band Level', Capability.`name` AS 'Capability'" +
                " FROM Job_Roles" +
                " INNER JOIN Banding ON Job_Roles.band_id = Banding.id"
                +
                " INNER JOIN Capability ON Job_Roles.capability_id = Capability.id");

        List<JobRoleResponse> jobRoleList = new ArrayList<>();

        while (rs.next()) {
            JobRoleResponse jobRoleResponse = new JobRoleResponse(
                    rs.getInt("ID"),
                    rs.getString("Name"),
                    rs.getString("Specification Description"),
                    rs.getString("URL Link"),
                    rs.getString("Band Level"),
                    rs.getString("Capability")
            );
            jobRoleList.add(jobRoleResponse);
        ResultSet rs = st.executeQuery("SELECT Job_Roles.id AS 'ID', Job_Roles.`name` AS 'Name', Capability.id AS 'Capability ID', Capability.`name` AS 'Capability Name'" +
                " FROM Job_Roles" +
                " INNER JOIN Capability ON Job_Roles.capability_id = Capability.id;");

        return jobRoleList;
    }
}
