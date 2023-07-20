package org.kainos.ea.integrationTests;

import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.model.JobRoleRequest;
import org.kainos.ea.trueApplication;
import org.kainos.ea.trueConfiguration;

import java.util.List;

@ExtendWith(DropwizardExtensionsSupport.class)
public class JobRoleControllerTest {
    static final DropwizardAppExtension<trueConfiguration> APP = new DropwizardAppExtension<>(trueApplication.class, null, new ResourceConfigurationSourceProvider());

    @Test
    void getJobRoles_shouldReturnListOfJobRoles() {
        List<JobRoleRequest> response = APP.client().target("http://localhost:8080/api/job-roles").request().get(List.class);
        Assertions.assertTrue(response.size() > 0);
    }
}
