package com.leyla.kittenrescue.service;

import com.leyla.kittenrescue.enums.Direction;
import com.leyla.kittenrescue.exception.KittenRescueApiException;
import com.leyla.kittenrescue.model.WomanInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
class KittenRescueServiceTest {

    @InjectMocks
    private KittenRescueServiceImpl kittenRescueService;

    @Mock
    private LocationApiServiceImpl locationApiService;

    @Test
    void should_not_get_directions_without_email() {
        Assertions.assertThrows(KittenRescueApiException.class, () -> {
            kittenRescueService.getDirections(null);
        });
    }

    @Test
    void should_not_find_woman_location_without_email() {
        Assertions.assertThrows(KittenRescueApiException.class, () -> {
            kittenRescueService.findWomanLocation(null);
        });
    }

    @Test
    void should_find_woman_location() {
        Mockito.when(locationApiService.getDirections("a@mail.com"))
               .thenReturn(Arrays.asList(Direction.FORWARD, Direction.FORWARD, Direction.LEFT, Direction.RIGHT, Direction.FORWARD));
        WomanInfo womanInfo = kittenRescueService.getWomanInfo(locationApiService.getDirections("a@mail.com"));
        Assertions.assertEquals(womanInfo.getLocation().getX(), 0);
        Assertions.assertEquals(womanInfo.getLocation().getY(), 3);
    }
}