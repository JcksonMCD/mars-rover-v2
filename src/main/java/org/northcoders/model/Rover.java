package org.northcoders.model;

public class Rover implements Driveable{
    private Position position;

    public Rover(Position position) {
        this.position = position;
    }

    @Override
    public void move() {

    }

    @Override
    public void turnRight() {
        switch (position.getFacing()){
            case N -> position.setFacing(CompassDirection.E);
            case E -> position.setFacing(CompassDirection.S);
            case S -> position.setFacing(CompassDirection.W);
            case W -> position.setFacing(CompassDirection.N);
        }
    }

    @Override
    public void turnLeft() {
        switch (position.getFacing()){
            case N -> position.setFacing(CompassDirection.W);
            case E -> position.setFacing(CompassDirection.N);
            case S -> position.setFacing(CompassDirection.E);
            case W -> position.setFacing(CompassDirection.S);
        }
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
