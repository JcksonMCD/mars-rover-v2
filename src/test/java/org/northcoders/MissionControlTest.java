package org.northcoders;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.northcoders.model.Plateau;
import org.northcoders.model.Position;
import org.northcoders.model.Rover;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.northcoders.model.CompassDirection.E;
import static org.northcoders.model.CompassDirection.N;

class MissionControlTest {

    @Test
    @DisplayName("Is position free returns true when position is free")
    void isPositionFreeReturnsTrueWhenPositionIsFree() {
        ArrayList<Rover> rovers = new ArrayList<>();
        rovers.add(new Rover(new Position(0, 0, N)));
        MissionControl missionControl = new MissionControl(new Plateau(1, 1), rovers);

        assertTrue(missionControl.isPositionFree(new Position(1, 1, N)));
    }

    @Test
    @DisplayName("Is position free returns false when position is not free")
    void isPositionFreeReturnsFalseWhenPositionIsNotFree() {
        ArrayList<Rover> rovers = new ArrayList<>();
        rovers.add(new Rover(new Position(0, 0, N)));
        MissionControl missionControl = new MissionControl(new Plateau(1, 1), rovers);

        assertFalse(missionControl.isPositionFree(new Position(0, 0, N)));
    }

    @Test
    @DisplayName("Is position free returns false when x and y values are taken even if facing field is different")
    void isPositionFreeReturnsFalseWhenXAndYAreTaken() {
        ArrayList<Rover> rovers = new ArrayList<>();
        rovers.add(new Rover(new Position(0, 0, N)));
        MissionControl missionControl = new MissionControl(new Plateau(1, 1), rovers);

        assertFalse(missionControl.isPositionFree(new Position(0, 0, E)));
    }

    @Test
    @DisplayName("Is position free returns true when X is taken but Y is free")
    void isPositionFreeReturnsTrueWhenYIsFree() {
        ArrayList<Rover> rovers = new ArrayList<>();
        rovers.add(new Rover(new Position(0, 0, N)));
        MissionControl missionControl = new MissionControl(new Plateau(1, 1), rovers);

        assertTrue(missionControl.isPositionFree(new Position(0, 1, N)));
    }

    @Test
    @DisplayName("Is position free returns true when Y is taken but X is free")
    void isPositionFreeReturnsTrueWhenXIsFree() {
        ArrayList<Rover> rovers = new ArrayList<>();
        rovers.add(new Rover(new Position(0, 0, N)));
        MissionControl missionControl = new MissionControl(new Plateau(1, 1), rovers);

        assertTrue(missionControl.isPositionFree(new Position(1, 0, N)));
    }

    @Test
    @DisplayName("Is position in bounds returns true when position is within plateau bounds")
    void isPositionInPlateauBoundsReturnsTrueWhenPositionIsInBounds() {
        MissionControl missionControl = new MissionControl(new Plateau(1, 1), null);

        assertTrue(missionControl.isPositionInPlateauBounds(new Position(1, 1, N)));
    }

    @Test
    @DisplayName("Is position in bounds returns false when position is out of plateau bounds")
    void isPositionInPlateauBoundsReturnsFalseWhenPositionIsOutOfBounds() {
        MissionControl missionControl = new MissionControl(new Plateau(1, 1), null);

        assertFalse(missionControl.isPositionInPlateauBounds(new Position(2, 2, N)));
    }
}