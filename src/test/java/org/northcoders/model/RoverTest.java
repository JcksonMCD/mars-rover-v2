package org.northcoders.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    @Test
    @DisplayName("When facing is North move method changes Y by +1")
    void moveNorth() {
        Rover rover = new Rover(new Position(1,1, CompassDirection.N));

        rover.move();

        assertEquals(2, rover.getPosition().getY());
    }

    @Test
    @DisplayName("When facing is East move method changes X by +1")
    void moveEast() {
        Rover rover = new Rover(new Position(1,1, CompassDirection.E));

        rover.move();

        assertEquals(2, rover.getPosition().getX());
    }

    @Test
    @DisplayName("When facing is South move method changes Y by -1")
    void moveSouth() {
        Rover rover = new Rover(new Position(1,1, CompassDirection.S));

        rover.move();

        assertEquals(0, rover.getPosition().getY());
    }

    @Test
    @DisplayName("When facing is West move method changes X by -1")
    void moveWest() {
        Rover rover = new Rover(new Position(1,1, CompassDirection.W));

        rover.move();

        assertEquals(0, rover.getPosition().getX());
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
    @DisplayName("Turn left method alters facing field from N to W")
    void turnLeftNorthToWest() {
        Rover rover = new Rover(new Position(5,5, CompassDirection.N));

        rover.turnLeft();

        assertEquals(CompassDirection.W, rover.getPosition().getFacing());
    }

    @Test
    @DisplayName("Turn left method alters facing field from E to N")
    void turnLeftEastToNorth() {
        Rover rover = new Rover(new Position(5,5, CompassDirection.E));

        rover.turnLeft();

        assertEquals(CompassDirection.N, rover.getPosition().getFacing());
    }

    @Test
    @DisplayName("Turn left method alters facing field from S to E")
    void turnLeftSouthToEast() {
        Rover rover = new Rover(new Position(5,5, CompassDirection.S));

        rover.turnLeft();

        assertEquals(CompassDirection.E, rover.getPosition().getFacing());
    }

    @Test
    @DisplayName("Turn left method alters facing field from W to S")
    void turnLeftEastToWest() {
        Rover rover = new Rover(new Position(5,5, CompassDirection.W));

        rover.turnLeft();

        assertEquals(CompassDirection.S, rover.getPosition().getFacing());
    }

}