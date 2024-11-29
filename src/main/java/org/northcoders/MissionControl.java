package org.northcoders;

import org.northcoders.model.Instruction;
import org.northcoders.model.Plateau;
import org.northcoders.model.Position;
import org.northcoders.model.Rover;

import java.util.ArrayList;
import java.util.Queue;

public class MissionControl {
    private Plateau plateau;
    private final ArrayList<Rover> rovers;

    public MissionControl(Plateau plateau) {
        this.plateau = plateau;
        this.rovers = new ArrayList<>();
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    public ArrayList<Rover> getRovers() {
        return rovers;
    }

    public void executeRoverInstructions(Queue<Instruction> instructions, Rover rover){
        while (!instructions.isEmpty()){
            switch (instructions.poll()){
                case L -> rover.turnLeft();
                case R -> rover.turnRight();
                case M -> {
                    if (isPositionInPlateauBounds(simulateNextMove(rover)) && isPositionFree(simulateNextMove(rover))) {
                        rover.move();
                    } else if (!isPositionInPlateauBounds(simulateNextMove(rover))){
                        throw new IllegalArgumentException("Instruction moves plateau out of bounds: movement stopped");
                    } else {
                        throw new IllegalArgumentException("Instructions cause crash: ABORTED");
                    }
                }
            }
        }
    }

    public Position simulateNextMove(Rover rover){
        int nextX = rover.getPosition().getX() + rover.getPosition().getFacing().incrementX;
        int nextY = rover.getPosition().getY() + rover.getPosition().getFacing().incrementY;

        return new Position(nextX, nextY, rover.getPosition().getFacing());
    }

    public void addRover(Rover rover) {
        if (isPositionFree(rover.getPosition()) && isPositionInPlateauBounds(rover.getPosition())){
            rovers.add(rover);
        } else if (!isPositionInPlateauBounds(rover.getPosition())){
            throw new IllegalArgumentException("Rover can not be placed out of plateau bounds");
        } else {
            throw new IllegalArgumentException("Position already taken by another rover.");
        }
    }

    public boolean isPositionFree(Position position){
        for (Rover rover : rovers){
            if (rover.getPosition().getX() == position.getX()
                    && rover.getPosition().getY() == position.getY()){
                return false;
            }
        }
        return true;
    }

    public boolean isPositionInPlateauBounds(Position position){
        return position.getY() <= plateau.maxY()
                && position.getX() <= plateau.maxX()
                && position.getX() >= 0
                && position.getY() >=0 ;
    }


}
