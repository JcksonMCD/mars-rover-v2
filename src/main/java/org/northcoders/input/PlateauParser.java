package org.northcoders.input;

import org.northcoders.model.Plateau;
import org.northcoders.model.Position;

public class PlateauParser {

    public Plateau parsePlateauInput(String plateauInput){
        String[] seperatedXandY = plateauInput.split(" ");

        int x = Integer.parseInt(seperatedXandY[0]);
        int y = Integer.parseInt(seperatedXandY[1]);

        return new Plateau(x, y);
    }
}