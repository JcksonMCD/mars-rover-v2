package org.northcoders.input;

import org.northcoders.model.CompassDirection;
import org.northcoders.model.Position;

public class PositionParser {

    public boolean isValidPositionFormat(String positionInput){
        return positionInput.matches("^\\d+\\s+\\d+[neswNESW]$");
    }

    public Position parseStartingPosition(String positionInput){
        if (!isValidPositionFormat(positionInput.strip())) throw new IllegalArgumentException("Invalid format: You must use X Y N/E/S/W");

        String[] splitPositionValues = positionInput.replaceAll(" ", "").split("");

        int x = Integer.parseInt(splitPositionValues[0]);
        int y = Integer.parseInt(splitPositionValues[1]);
        CompassDirection facing = CompassDirection.valueOf(splitPositionValues[2].toUpperCase());

        return new Position(x, y, facing);
    }
}
