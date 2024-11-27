package org.northcoders.input;

import org.northcoders.model.Plateau;


public class PlateauParser {

    private boolean isValidPlateauFormat(String plateauInput){
        return plateauInput.trim().matches("^\\d+\\s+\\d+");
    }

    public Plateau parsePlateauInput(String plateauInput){
        if (!isValidPlateauFormat(plateauInput)) throw new IllegalArgumentException();

        String[] seperatedXandY = plateauInput.trim().split("\\s+");

        int x = Integer.parseInt(seperatedXandY[0]);
        int y = Integer.parseInt(seperatedXandY[1]);

        return new Plateau(x, y);
    }
}
