package org.kainos.ea.integrationTests;

import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.model.Band;
import org.kainos.ea.model.Capability;
import org.kainos.ea.trueApplication;
import org.kainos.ea.trueConfiguration;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(DropwizardExtensionsSupport.class)
public class BandControllerTest {
    static final DropwizardAppExtension<trueConfiguration> APP = new DropwizardAppExtension<>(trueApplication.class, null, new ResourceConfigurationSourceProvider());

    @Test
    void getAllBands_shouldReturnListOfBands() {
        Response response = APP.client().target("http://localhost:8080/api/band").request().get();
        assertEquals(200, response.getStatus());
        List<Band> bandList = response.readEntity(new GenericType<List<Band>>() {
        });
        assertTrue(bandList.size() > 0);
        Band band = bandList.get(0);
        String expected = "Manager";
        String actual = band.getBandLevel();
        assertEquals(expected, actual);
    }

}
