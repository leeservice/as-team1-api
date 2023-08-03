package org.kainos.ea.dao;

import org.kainos.ea.model.RegisterUser;

import java.sql.*;

public class AuthDao {

    public int register(RegisterUser login, Connection c) throws SQLException {
        String insertStatement = "INSERT INTO `User` (email, password, role_id) VALUES (?,?,?)";
        PreparedStatement st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);
        st.setString(1, login.getEmail());
        st.setString(2, login.getPassword());
        st.setInt(3, login.getRole().getRoleId());
        System.out.println(login);
        st.executeUpdate();


        ResultSet  rs = st.getGeneratedKeys();
        if(rs.next())
        {
            return rs.getInt(1);
        }
        return  -1;
    }

}
