package org.northcoders.input;

import org.northcoders.model.CompassDirection;
import org.northcoders.model.Position;


public class PositionParser {

    private boolean isValidPositionFormat(String positionInput){
        return positionInput.matches("^\\d+\\s+\\d+\\s+[neswNESW]$");
    }

    public Position parseStartingPosition(String positionInput){
        if (!isValidPositionFormat(positionInput.strip())) throw new IllegalArgumentException("Invalid format: You must use X Y N/E/S/W");

        String[] positionValuesMinusWhitespace = positionInput.strip().split("\s+");

        int x = Integer.parseInt(positionValuesMinusWhitespace[0]);
        int y = Integer.parseInt(positionValuesMinusWhitespace[1]);
        CompassDirection facing = CompassDirection.valueOf(positionValuesMinusWhitespace[2].toUpperCase());

        return new Position(x, y, facing);
    }
}
