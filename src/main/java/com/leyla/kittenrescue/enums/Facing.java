package com.leyla.kittenrescue.enums;

import java.util.HashMap;
import java.util.Map;

public enum Facing {

    NORTH(0, 1),
    SOUTH(0, -1),
    EAST(1, 0),
    WEST(-1, 0);

    private final int x;

    private final int y;

    private static final Map<Facing, Facing[]> directionToFacing = new HashMap<>();

    //directionToFacing map determines the new direction based on current facing state. Uses enum Direction.class facing index.

    static {
        directionToFacing.put(Facing.NORTH, new Facing[] { Facing.WEST, Facing.EAST, Facing.NORTH });
        directionToFacing.put(Facing.SOUTH, new Facing[] { Facing.EAST, Facing.WEST, Facing.SOUTH });
        directionToFacing.put(Facing.EAST, new Facing[] { Facing.NORTH, Facing.SOUTH, Facing.EAST });
        directionToFacing.put(Facing.WEST, new Facing[] { Facing.SOUTH, Facing.NORTH, Facing.WEST });
    }

    public static Map<Facing, Facing[]> getDirectionToFacing() {
        return directionToFacing;
    }

    Facing(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
