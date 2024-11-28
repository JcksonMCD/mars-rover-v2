package org.northcoders;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.northcoders.model.Instruction;
import org.northcoders.model.Plateau;
import org.northcoders.model.Position;
import org.northcoders.model.Rover;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.northcoders.model.CompassDirection.*;
import static org.northcoders.model.Instruction.*;

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

    @Test
    @DisplayName("Is position in bounds returns false when only X value is out of plateau bounds")
    void isPositionInPlateauBoundsReturnsFalseWhenOnlyXIsOutOfBounds() {
        MissionControl missionControl = new MissionControl(new Plateau(1, 1), null);

        assertFalse(missionControl.isPositionInPlateauBounds(new Position(2, 1, N)));
    }

    @Test
    @DisplayName("Is position in bounds returns false when only Y value is out of plateau bounds")
    void isPositionInPlateauBoundsReturnsFalseWhenOnlyYIsOutOfBounds() {
        MissionControl missionControl = new MissionControl(new Plateau(1, 1), null);

        assertFalse(missionControl.isPositionInPlateauBounds(new Position(1, 2, N)));
    }

    @Test
    @DisplayName("Add rover adds a rover to mission control")
    void addRover() {
        ArrayList<Rover> rovers = new ArrayList<>();
        MissionControl missionControl = new MissionControl(new Plateau(5, 5), rovers);

        missionControl.addRover(new Rover(new Position(2, 2, N)));

        assertEquals(missionControl.getRovers().getFirst().getPosition().getFacing(), N);
        assertEquals(missionControl.getRovers().getFirst().getPosition().getX(), 2);
        assertEquals(missionControl.getRovers().getFirst().getPosition().getY(), 2);
    }

    @Test
    @DisplayName("Add rover throws exception if rover is out of plateau bounds")
    void addRoverThrowsExceptionWhenRoverIsOutOfPlateauBounds() {
        ArrayList<Rover> rovers = new ArrayList<>();
        MissionControl missionControl = new MissionControl(new Plateau(5, 5), rovers);

        assertThrows(IllegalArgumentException.class, () -> missionControl.addRover(new Rover(new Position(6, 6, N))));
    }

    @Test
    @DisplayName("Add rover throws exception if rover position is taken")
    void addRoverThrowsExceptionWhenRoverPositionIsTaken() {
        ArrayList<Rover> rovers = new ArrayList<>();
        rovers.add(new Rover(new Position(0, 0, N)));
        MissionControl missionControl = new MissionControl(new Plateau(5, 5), rovers);

        assertThrows(IllegalArgumentException.class, () -> missionControl.addRover(new Rover(new Position(0, 0, N))));
    }

    @Test
    @DisplayName("Add rover throws exception if rover position is taken even if facing is different")
    void addRoverThrowsExceptionWhenRoverPositionIsTakenEvenIfFacingIsDifferent() {
        ArrayList<Rover> rovers = new ArrayList<>();
        rovers.add(new Rover(new Position(0, 0, N)));
        MissionControl missionControl = new MissionControl(new Plateau(5, 5), rovers);

        assertThrows(IllegalArgumentException.class, () -> missionControl.addRover(new Rover(new Position(0, 0, E))));
    }

    @Test
    @DisplayName("Executes rover instructions executes single instruction: L")
    void executeRoverInstructionL() {
        Queue<Instruction> instructions = new LinkedList<>();
        instructions.add(L);
        Rover rover = new Rover(new Position(0, 0, N));
        ArrayList<Rover> rovers = new ArrayList<>();
        rovers.add(rover);
        MissionControl missionControl = new MissionControl(new Plateau(5, 5), rovers);

        missionControl.executeRoverInstructions(instructions, rover);

        assertEquals(W, missionControl.getRovers().getFirst().getPosition().getFacing());
    }

    @Test
    @DisplayName("Executes rover instructions executes single instruction: R")
    void executeRoverInstructionR() {
        Queue<Instruction> instructions = new LinkedList<>();
        instructions.add(R);
        Rover rover = new Rover(new Position(0, 0, N));
        ArrayList<Rover> rovers = new ArrayList<>();
        rovers.add(rover);
        MissionControl missionControl = new MissionControl(new Plateau(5, 5), rovers);

        missionControl.executeRoverInstructions(instructions, rover);

        assertEquals(E, missionControl.getRovers().getFirst().getPosition().getFacing());
    }

    @Test
    @DisplayName("Executes rover instructions executes single instruction: M")
    void executeRoverInstructionM() {
        Queue<Instruction> instructions = new LinkedList<>();
        instructions.add(M);
        Rover rover = new Rover(new Position(0, 0, N));
        ArrayList<Rover> rovers = new ArrayList<>();
        rovers.add(rover);
        MissionControl missionControl = new MissionControl(new Plateau(5, 5), rovers);

        missionControl.executeRoverInstructions(instructions, rover);

        assertEquals(1, missionControl.getRovers().getFirst().getPosition().getY());
    }

    @Test
    @DisplayName("Executes rover instructions executes queue of instruction")
    void executeRoverInstructions() {
        Queue<Instruction> instructions = new LinkedList<>();
        instructions.add(M);
        instructions.add(R);
        instructions.add(M);
        instructions.add(L);

        Rover rover = new Rover(new Position(0, 0, N));
        ArrayList<Rover> rovers = new ArrayList<>();
        rovers.add(rover);
        MissionControl missionControl = new MissionControl(new Plateau(5, 5), rovers);

        missionControl.executeRoverInstructions(instructions, rover);

        assertEquals(1, missionControl.getRovers().getFirst().getPosition().getY());
        assertEquals(1, missionControl.getRovers().getFirst().getPosition().getX());
        assertEquals(N, missionControl.getRovers().getFirst().getPosition().getFacing());
    }

    @Test
    @DisplayName("Executes rover instructions throws error if rover moves out of bounds")
    void executeRoverInstructionsThrowsErrorIfRoverMovesOutOfBounds() {
        Queue<Instruction> instructions = new LinkedList<>();
        instructions.add(M);

        Rover rover = new Rover(new Position(5, 5, N));
        ArrayList<Rover> rovers = new ArrayList<>();
        rovers.add(rover);
        MissionControl missionControl = new MissionControl(new Plateau(5, 5), rovers);

        assertThrows(IllegalArgumentException.class, () -> missionControl.executeRoverInstructions(instructions, rover));
    }

    @Test
    @DisplayName("Executes rover instructions throws error if rover moves into other rover")
    void executeRoverInstructionsThrowsErrorIfRoverMovesIntoOtherRover() {
        Queue<Instruction> instructions = new LinkedList<>();
        instructions.add(M);

        Rover rover = new Rover(new Position(5, 4, N));
        ArrayList<Rover> rovers = new ArrayList<>();
        rovers.add(rover);
        rovers.add(new Rover(new Position(5, 5, N)));
        MissionControl missionControl = new MissionControl(new Plateau(5, 5), rovers);

        assertThrows(IllegalArgumentException.class, () -> missionControl.executeRoverInstructions(instructions, rover));
    }


}