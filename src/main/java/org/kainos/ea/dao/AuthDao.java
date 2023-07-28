package org.kainos.ea.dao;

import org.apache.commons.lang3.time.DateUtils;
import org.kainos.ea.model.Login;

import java.sql.*;
import java.util.Date;
import java.util.UUID;

public class AuthDao {
    public boolean validLogin(Login login, Connection c) throws SQLException {
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT `password` FROM `User` WHERE email = '" + login.getEmail() + "';");

        if(rs.next()) {
            return rs.getString("Password").equals(login.getPassword());
        } else {
            return false;
        }
    }

    public String generateToken(int userId, Connection c) throws SQLException {
        String token = UUID.randomUUID().toString();
        Date expiry = DateUtils.addHours(new Date(), 8);

        String insertStatement = "INSERT INTO Token (token, user_id, expires_at) VALUES (?, ?, ?);";
        PreparedStatement st = c.prepareStatement(insertStatement);

        st.setString(1, token);
        st.setInt(2, userId);
        st.setTimestamp(3, new java.sql.Timestamp(expiry.getTime()));

        st.executeUpdate();
        return token;
    }
}
