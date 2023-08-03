package org.kainos.ea.controllerTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.controller.CapabilityController;
import org.kainos.ea.exceptions.FailedToGetCapabilityException;
import org.kainos.ea.service.CapabilityService;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CapabilityResponseControllerTest {
    CapabilityService capabilityService = mock(CapabilityService.class);
    CapabilityController capabilityController = new CapabilityController(capabilityService);

    @Test
    void getAllCapabilities_shouldReturn500_whenCapabilityServiceThrowsFailedToGetCapabilityException() throws FailedToGetCapabilityException {
        when(capabilityService.getAllCapabilities()).thenThrow(FailedToGetCapabilityException.class);
        assertEquals(500, capabilityController.getAllCapabilities().getStatus());
    }
}
