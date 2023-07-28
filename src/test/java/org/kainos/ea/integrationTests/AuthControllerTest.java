package org.kainos.ea.integrationTests;

import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.trueApplication;
import org.kainos.ea.trueConfiguration;

import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(DropwizardExtensionsSupport.class)
public class AuthControllerTest {
    static final DropwizardAppExtension<trueConfiguration> APP =
            new DropwizardAppExtension<>(
                    trueApplication.class, null, new ResourceConfigurationSourceProvider());
}
