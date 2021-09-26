package com.leyla.kittenrescue.service;

import com.leyla.kittenrescue.enums.Direction;
import com.leyla.kittenrescue.model.Location;
import com.leyla.kittenrescue.model.response.LocationResponse;

import java.util.List;

public interface LocationApiService {

    List<Direction> getDirections(String email);

    LocationResponse getLocation(String email, Location location);
}
