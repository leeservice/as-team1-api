package org.kainos.ea.dao;

import org.kainos.ea.model.RegisterUser;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AuthDao {

    public boolean registerNewUser(Connection c, RegisterUser user) throws SQLException {
        Statement st = c.createStatement();

        st.executeQuery("INSERT INTO Users (email, `password`, role_id) VALUES ('" + user.getEmail() + "', '" + user.getPassword() + "', '" + user.getRole().getRoleId() + "');");

        return true;


    }

}
