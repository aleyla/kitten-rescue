package com.leyla.kittenrescue.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Direction {
    @JsonProperty("left") LEFT(0),
    @JsonProperty("right") RIGHT(1),
    @JsonProperty("forward") FORWARD(2);

    private final int facingIndex;

    Direction(int facingIndex) {
        this.facingIndex = facingIndex;
    }

    public int getFacingIndex() {
        return facingIndex;
    }
}
