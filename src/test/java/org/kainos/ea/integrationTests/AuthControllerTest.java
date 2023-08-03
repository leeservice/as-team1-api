package org.kainos.ea.integrationTests;

import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.model.LoginRequest;
import org.kainos.ea.trueApplication;
import org.kainos.ea.trueConfiguration;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(DropwizardExtensionsSupport.class)
public class AuthControllerTest {
    static final DropwizardAppExtension<trueConfiguration> APP =
            new DropwizardAppExtension<>(
                    trueApplication.class, null, new ResourceConfigurationSourceProvider());

    @Test
    void login_shouldReturnToken() {
        String username = System.getenv("TEST_USERNAME");
        String password = System.getenv("TEST_PASSWORD");
        LoginRequest loginRequest = new LoginRequest(username, password);
        Response response =
                APP.client().target("http://localhost:8080/api/login").request().post(Entity.entity(loginRequest, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(200, response.getStatus());
        String token = response.readEntity(String.class);
        assertNotNull(token);
    }

    @Test
    void login_shouldReturn401_whenCredentialsInvalid() {
        LoginRequest loginRequest = new LoginRequest("invaliduser@kainos.com", "invaliduser");
        Response response =
                APP.client().target("http://localhost:8080/api/login").request().post(Entity.entity(loginRequest, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(401, response.getStatus());
    }
}
