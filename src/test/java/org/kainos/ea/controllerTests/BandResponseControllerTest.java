package org.kainos.ea.controllerTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.controller.BandController;
import org.kainos.ea.exceptions.FailedToGetBandException;
import org.kainos.ea.service.BandService;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BandResponseControllerTest {
    BandService bandService = mock(BandService.class);
    BandController bandController = new BandController(bandService);

    @Test
    void getAllBands_shouldReturn500_whenBandServiceThrowsFailedToGetBandException() throws FailedToGetBandException {
        when(bandService.getAllBands()).thenThrow(FailedToGetBandException.class);
        assertEquals(500, bandController.getAllBands().getStatus());
    }
}
