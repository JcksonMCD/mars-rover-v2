package org.northcoders.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Rover implements Driveable{
    private Position position;

    @Override
    public void move() {
        position.setX(position.getX() + position.getFacing().incrementX);
        position.setY(position.getY() + position.getFacing().incrementY);
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
}
