package com.leyla.kittenrescue.service;

import com.leyla.kittenrescue.exception.KittenRescueApiException;
import com.leyla.kittenrescue.model.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LocationApiServiceTest {

    @InjectMocks
    private LocationApiServiceImpl locationApiService;

    @Test
    void should_not_get_directions_without_email() {
        Assertions.assertThrows(KittenRescueApiException.class, () -> {
            locationApiService.getDirections(null);
        });
    }

    @Test
    void should_not_get_directions_blank_email() {
        Assertions.assertThrows(KittenRescueApiException.class, () -> {
            locationApiService.getDirections("");
        });
    }

    @Test
    void should_not_get_location_without_email() {
        Assertions.assertThrows(KittenRescueApiException.class, () -> {
            locationApiService.getLocation(null, new Location());
        });
    }

    @Test
    void should_not_get_location_blank_email() {
        Assertions.assertThrows(KittenRescueApiException.class, () -> {
            locationApiService.getLocation("", new Location());
        });
    }

    @Test
    void should_not_get_location_without_location() {
        Assertions.assertThrows(KittenRescueApiException.class, () -> {
            locationApiService.getLocation("a@mail.com", null);
        });
    }

}