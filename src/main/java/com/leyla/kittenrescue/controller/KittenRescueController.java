package com.leyla.kittenrescue.controller;

import com.leyla.kittenrescue.enums.Direction;
import com.leyla.kittenrescue.model.Location;
import com.leyla.kittenrescue.model.request.EmailRequest;
import com.leyla.kittenrescue.model.request.GuessLocationRequest;
import com.leyla.kittenrescue.model.response.LocationResponse;
import com.leyla.kittenrescue.service.KittenRescueService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/kitten-rescue")
public class KittenRescueController {

    private final KittenRescueService service;

    public KittenRescueController(KittenRescueService service) {
        this.service = service;
    }

    @GetMapping(value = "/directions")
    public List<Direction> getDirections(@Valid EmailRequest request) {
        return service.getDirections(request);
    }

    @GetMapping(value = "/find")
    public LocationResponse findWomanLocation(@Valid EmailRequest request) {
        return service.findWomanLocation(request);
    }

    @GetMapping(value = "/coordinate-clue")
    public Location getCoordinateClue(@Valid EmailRequest request) {
        return service.getCoordinateClue(request);
    }

    @GetMapping(value = "/guess-location")
    public LocationResponse guessLocation(@Valid GuessLocationRequest request) {
        return service.guessLocation(request);
    }

}

