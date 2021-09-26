package com.leyla.kittenrescue.model.response;

import com.leyla.kittenrescue.enums.Direction;

import java.util.List;

public class DirectionResponse {

    private List<Direction> directions;

    public List<Direction> getDirections() {
        return directions;
    }

    public void setDirections(List<Direction> directions) {
        this.directions = directions;
    }
}
