package com.leyla.kittenrescue.service;

import com.leyla.kittenrescue.client.WhichApiClient;
import com.leyla.kittenrescue.enums.Direction;
import com.leyla.kittenrescue.enums.ErrorCodeEnum;
import com.leyla.kittenrescue.exception.KittenRescueApiException;
import com.leyla.kittenrescue.model.Location;
import com.leyla.kittenrescue.model.response.LocationResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationApiServiceImpl implements LocationApiService {

    private final WhichApiClient client;

    public LocationApiServiceImpl(WhichApiClient client) {
        this.client = client;
    }

    @Override
    public List<Direction> getDirections(String email) {
        validateEmail(email);
        return client.getDirections(email).getDirections();
    }

    @Override
    public LocationResponse getLocation(String email, Location location) {
        validateEmail(email);
        if (location == null) {
            throw new KittenRescueApiException(ErrorCodeEnum.BAD_REQUEST_ERROR);
        }
        return client.getLocation(email, location.getX(), location.getY());
    }

    private void validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new KittenRescueApiException(ErrorCodeEnum.BAD_REQUEST_ERROR);
        }
    }
}
