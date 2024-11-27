package org.northcoders.input;

import org.northcoders.model.CompassDirection;
import org.northcoders.model.Position;

public class PositionParser {

    public Position parseStartingPosition(String positionInput){
        String[] splitPositionValues = positionInput.replaceAll(" ", "").split("");

        int x = Integer.parseInt(splitPositionValues[0]);
        int y = Integer.parseInt(splitPositionValues[1]);
        CompassDirection facing = CompassDirection.valueOf(splitPositionValues[2].toUpperCase());

        return new Position(x, y, facing);
    }
}
