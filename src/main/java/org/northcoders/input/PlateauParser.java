package org.northcoders.input;

import org.northcoders.model.Plateau;


public class PlateauParser {

    public Plateau parsePlateauInput(String plateauInput){
        String[] seperatedXandY = plateauInput.trim().split("\s+");

        int x = Integer.parseInt(seperatedXandY[0]);
        int y = Integer.parseInt(seperatedXandY[1]);

        return new Plateau(x, y);
    }
}
