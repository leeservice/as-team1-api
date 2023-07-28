package org.kainos.ea.dao;
import org.kainos.ea.model.CapabilityResponse;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CapabilityDao {
    public List<CapabilityResponse> getAllCapabilities(Connection c) throws SQLException {
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT id AS 'ID', `name` AS 'Name'"
        + " FROM CapabilityResponse;");

        List<CapabilityResponse> capabilityResponseList = new ArrayList<>();

        while (rs.next()) {
            CapabilityResponse capabilityResponse = new CapabilityResponse(rs.getInt("ID"), rs.getString("Name"));
            capabilityResponseList.add(capabilityResponse);
        }
        return capabilityResponseList;
    }
}
