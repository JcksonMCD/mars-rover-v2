package org.northcoders;

import org.northcoders.model.Plateau;
import org.northcoders.model.Rover;

import java.util.ArrayList;

public class MissionControl {
    private Plateau plateau;
    private ArrayList<Rover> rovers;

    public MissionControl(Plateau plateau, ArrayList<Rover> rovers) {
        this.plateau = plateau;
        this.rovers = rovers;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    public ArrayList<Rover> getRovers() {
        return rovers;
    }

    public void setRovers(ArrayList<Rover> rovers) {
        this.rovers = rovers;
    }
}
