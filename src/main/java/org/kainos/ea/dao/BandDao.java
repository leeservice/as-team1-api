package org.kainos.ea.dao;

import org.kainos.ea.model.BandResponse;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BandDao {
    public List<BandResponse> getAllBands(Connection c) throws SQLException {
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT id AS 'ID', level_of_band AS 'Band Level'"
                + " FROM Banding;");
        List<BandResponse> bandResponseList = new ArrayList<>();
        while (rs.next()) {
            BandResponse bandResponse = new BandResponse(rs.getInt("ID"), rs.getString("Band Level"));
            bandResponseList.add(bandResponse);
        }
        return bandResponseList;
    }
}
