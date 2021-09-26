package com.leyla.kittenrescue.model;

import com.leyla.kittenrescue.enums.Facing;

public class WomanInfo {

    private Location location = new Location();

    private Facing facing = Facing.NORTH;

    public Location updateLocation(int x, int y) {
        this.location.updateXY(x, y);
        return location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Facing getFacing() {
        return facing;
    }

    public void setFacing(Facing facing) {
        this.facing = facing;
    }
}
