package com.leyla.kittenrescue.model;

public class Location {

    private int x = 0;

    private int y = 0;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void updateXY(int x, int y) {
        this.x = this.x + x;
        this.y = this.y + y;
    }

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Location() {
    }

    @Override
    public String toString() {
        return "Location{" + "x=" + x + ", y=" + y + '}';
    }
}
