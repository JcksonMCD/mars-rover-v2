package org.northcoders.input;

import org.northcoders.model.CompassDirection;
import org.northcoders.model.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PositionParser {

    public boolean isValidPositionFormat(String positionInput){
        return positionInput.matches("^\\d+\\s+\\d+\\s+[neswNESW]$");
    }

    public Position parseStartingPosition(String positionInput){
        if (!isValidPositionFormat(positionInput.strip())) throw new IllegalArgumentException("Invalid format: You must use X Y N/E/S/W");

        String[] splitPositionValues = positionInput.split(" ");
        ArrayList<String> positionValuesMinusWhitespace = new ArrayList<>();

        for(String value : splitPositionValues){
            if (!value.equals(" ") && !value.isEmpty()) positionValuesMinusWhitespace.add(value);
        }

        int x = Integer.parseInt(positionValuesMinusWhitespace.getFirst());
        int y = Integer.parseInt(positionValuesMinusWhitespace.get(1));
        CompassDirection facing = CompassDirection.valueOf(positionValuesMinusWhitespace.get(2).toUpperCase());

        return new Position(x, y, facing);
    }
}
