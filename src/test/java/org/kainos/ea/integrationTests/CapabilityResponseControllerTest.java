package org.kainos.ea.integrationTests;

import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.model.CapabilityResponse;
import org.kainos.ea.trueApplication;
import org.kainos.ea.trueConfiguration;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(DropwizardExtensionsSupport.class)
public class CapabilityResponseControllerTest {
    static final DropwizardAppExtension<trueConfiguration> APP = new DropwizardAppExtension<>(trueApplication.class, null, new ResourceConfigurationSourceProvider());

    @Test
    void getAllCapabilities_shouldReturnListOfCapabilities() {
        Response response = APP.client().target("http://localhost:8080/api/capability").request().get();
        assertEquals(200, response.getStatus());
        List<CapabilityResponse> capabilityResponseList = response.readEntity(new GenericType<List<CapabilityResponse>>() {
        });
        assertTrue(capabilityResponseList.size() > 0);
        CapabilityResponse capabilityResponse = capabilityResponseList.get(0);
        String expected = "Engineering";
        String actual = capabilityResponse.getName();
        assertEquals(expected, actual);
    }
}
