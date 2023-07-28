package org.kainos.ea.dao;

import org.apache.commons.lang3.time.DateUtils;
import org.kainos.ea.model.Login;
import org.kainos.ea.model.LoginRequest;

import java.sql.*;
import java.util.Date;
import java.util.UUID;

public class AuthDao {
    public boolean validLogin(LoginRequest loginRequest, Connection c) throws SQLException {
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT `password` FROM `User` WHERE email = '" + loginRequest.getEmail() + "';");

        if(rs.next()) {
            return rs.getString("password").equals(loginRequest.getPassword());
        } else {
            return false;
        }
    }

    public int getUserIdFromEmail(String email, Connection c) throws SQLException {
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT id FROM `User` WHERE email = '" + email + "';");

        if(rs.next()) {
            return rs.getInt("id");
        } else {
            return -1;
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
