package org.northcoders.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    @Test
    void move() {
    }

    @Test
    @DisplayName("Turn right method alters facing field from N to E")
    void turnRightNorthToEast() {
        Rover rover = new Rover(new Position(5,5, CompassDirection.N));

        rover.turnRight();

        assertEquals(CompassDirection.E, rover.getPosition().getFacing());
    }

    @Test
    @DisplayName("Turn right method alters facing field from E to S")
    void turnRightEastToWest() {
        Rover rover = new Rover(new Position(5,5, CompassDirection.E));

        rover.turnRight();

        assertEquals(CompassDirection.S, rover.getPosition().getFacing());
    }

    @Test
    @DisplayName("Turn right method alters facing field from S to W")
    void turnRightSouthToWest() {
        Rover rover = new Rover(new Position(5,5, CompassDirection.S));

        rover.turnRight();

        assertEquals(CompassDirection.W, rover.getPosition().getFacing());
    }

    @Test
    @DisplayName("Turn right method alters facing field from W to N")
    void turnRightWestToNorth() {
        Rover rover = new Rover(new Position(5,5, CompassDirection.W));

        rover.turnRight();

        assertEquals(CompassDirection.N, rover.getPosition().getFacing());
    }

    @Test
    void turnLeft() {
    }
}