package org.northcoders.input;

import org.northcoders.model.Plateau;


public class PlateauParser {

    private boolean isValidPlateauFormat(String plateauInput){
        return plateauInput.trim().matches("^[1-9]\\d*\\s+[1-9]\\d*$");
    }

    public Plateau parsePlateauInput(String plateauInput){
        if (!isValidPlateauFormat(plateauInput)) throw new IllegalArgumentException(
                "Invalid format: You must input two numbers separated by a space. Neither number can be negative or zero.");

        String[] seperatedXandY = plateauInput.trim().split("\\s+");

        int x = Integer.parseInt(seperatedXandY[0]);
        int y = Integer.parseInt(seperatedXandY[1]);

        return new Plateau(x, y);
    }
}
