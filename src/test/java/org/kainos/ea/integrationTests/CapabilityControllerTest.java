package org.kainos.ea.integrationTests;

import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.model.Capability;
import org.kainos.ea.trueApplication;
import org.kainos.ea.trueConfiguration;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(DropwizardExtensionsSupport.class)
public class CapabilityControllerTest {
    static final DropwizardAppExtension<trueConfiguration> APP = new DropwizardAppExtension<>(trueApplication.class, null, new ResourceConfigurationSourceProvider());

    @Test
    void getAllCapabilities_shouldReturnListOfCapabilities() {
        Response response = APP.client().target("http://localhost:8080/api/capability").request().get();
        assertEquals(200, response.getStatus());
        List<Capability> capabilityList = response.readEntity(new GenericType<List<Capability>>() {
        });
        assertTrue(capabilityList.size() > 0);
        Capability capability = capabilityList.get(0);
        String expected = "Engineering";
        String actual = capability.getName();
        assertEquals(expected, actual);
    }
}
