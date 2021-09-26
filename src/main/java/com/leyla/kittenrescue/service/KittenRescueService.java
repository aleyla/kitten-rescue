package com.leyla.kittenrescue.service;

import com.leyla.kittenrescue.enums.Direction;
import com.leyla.kittenrescue.model.Location;
import com.leyla.kittenrescue.model.request.EmailRequest;
import com.leyla.kittenrescue.model.request.GuessLocationRequest;
import com.leyla.kittenrescue.model.response.LocationResponse;

import java.util.List;

public interface KittenRescueService {

    List<Direction> getDirections(EmailRequest request);

    LocationResponse findWomanLocation(EmailRequest request);

    Location getCoordinateClue(EmailRequest request);

    LocationResponse guessLocation(GuessLocationRequest request);

}
