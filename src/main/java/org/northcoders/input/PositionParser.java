package org.northcoders.input;

import org.northcoders.model.CompassDirection;
import org.northcoders.model.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PositionParser {

    private boolean isValidPositionFormat(String positionInput){
        return positionInput.matches("^\\d+\\s+\\d+\\s+[neswNESW]$");
    }

    private ArrayList<String> removeWhitespaceFromArray(String[] arrayWithWhitespace){
        ArrayList<String> valuesMinusWhitespace = new ArrayList<>();

        for(String value : arrayWithWhitespace){
            if (!value.equals(" ") && !value.isEmpty()) valuesMinusWhitespace.add(value);
        }

        return  valuesMinusWhitespace;
    }

    public Position parseStartingPosition(String positionInput){
        if (!isValidPositionFormat(positionInput.strip())) throw new IllegalArgumentException("Invalid format: You must use X Y N/E/S/W");

        ArrayList<String> positionValuesMinusWhitespace = removeWhitespaceFromArray(positionInput.split(" "));

        int x = Integer.parseInt(positionValuesMinusWhitespace.getFirst());
        int y = Integer.parseInt(positionValuesMinusWhitespace.get(1));
        CompassDirection facing = CompassDirection.valueOf(positionValuesMinusWhitespace.get(2).toUpperCase());

        return new Position(x, y, facing);
    }
}
