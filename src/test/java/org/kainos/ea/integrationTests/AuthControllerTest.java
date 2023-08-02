package org.kainos.ea.integrationTests;

import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.exceptions.DatabaseConnectionException;
import org.kainos.ea.model.JobRoleResponse;
import org.kainos.ea.model.RegisterUser;
import org.kainos.ea.trueApplication;
import org.kainos.ea.trueConfiguration;
import org.kainos.ea.utility.DatabaseConnector;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.sql.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(DropwizardExtensionsSupport.class)
public class AuthControllerTest {
    static final DropwizardAppExtension<trueConfiguration> APP =
            new DropwizardAppExtension<>(
                    trueApplication.class, null, new ResourceConfigurationSourceProvider());


    Connection c;
    {
        try {
            c = new DatabaseConnector().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (DatabaseConnectionException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void registerValidUser_shouldReturnAnId() throws SQLException {
        String sampleEmail = "ryan@kainosmail.com";

        // Post to the endpoint
        Response response = APP.client().target("http://localhost:8080/api/register").request().post(
                Entity.json("{\"email\":\"" + sampleEmail + "\",\"password\":\"MYsuperS3cureP@ss\",\"role\":\"admin\"}")
        );

        //Assert that the correct status code is returned
        assertEquals(201, response.getStatus());

        //The Returned ID of the New user
        int id = response.readEntity(int.class);

        // Select new User From DB
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT email, `password` from User WHERE id = " + id + ";");
        String userInDb = "";
        while (rs.next()){
            userInDb = rs.getString("email");
        }
        //Assert that the Id that is returned equates to the new user
        assertEquals(sampleEmail, userInDb);

        //Delete Added User
        String deleteStatement = "DELETE from User WHERE id = ?";
        PreparedStatement dst = c.prepareStatement(deleteStatement, Statement.RETURN_GENERATED_KEYS);
        dst.setInt(1, id);
        dst.executeUpdate();


    }
}
