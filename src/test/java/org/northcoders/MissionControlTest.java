package org.northcoders;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.northcoders.model.Plateau;
import org.northcoders.model.Position;
import org.northcoders.model.Rover;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
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
}