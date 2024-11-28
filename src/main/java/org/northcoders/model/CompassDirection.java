package org.northcoders.model;

public enum CompassDirection {
    N(0, 1),
    E(1, 0),
    S(0, -1),
    W(-1, 0);

    public final int incrementX;
    public final int incrementY;

    CompassDirection(int incrementX, int incrementY) {
        this.incrementX = incrementX;
        this.incrementY = incrementY;
    }
}
