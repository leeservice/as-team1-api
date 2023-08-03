package org.kainos.ea.integrationTests;

import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.model.BandResponse;
import org.kainos.ea.trueApplication;
import org.kainos.ea.trueConfiguration;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(DropwizardExtensionsSupport.class)
public class BandResponseControllerTest {
    static final DropwizardAppExtension<trueConfiguration> APP = new DropwizardAppExtension<>(trueApplication.class, null, new ResourceConfigurationSourceProvider());

    @Test
    void getAllBands_shouldReturnListOfBands() {
        Response response = APP.client().target("http://localhost:8080/api/band").request().get();
        assertEquals(200, response.getStatus());
        List<BandResponse> bandResponseList = response.readEntity(new GenericType<List<BandResponse>>() {
        });
        assertTrue(bandResponseList.size() > 0);
        BandResponse bandResponse = bandResponseList.get(0);
        String expected = "Apprentice";
        String actual = bandResponse.getBandLevel();
        assertEquals(expected, actual);
    }

}
