package org.northcoders.input;

import org.northcoders.model.Plateau;


public class PlateauParser {

    public Plateau parsePlateauInput(String plateauInput){
        String[] separatedXandY = plateauInput.trim().split("\s+");

        int x = Integer.parseInt(separatedXandY[0]);
        int y = Integer.parseInt(separatedXandY[1]);

        return new Plateau(x, y);
    }
}
