package org.northcoders.ui;

import org.northcoders.MissionControl;
import org.northcoders.input.PlateauParser;
import org.northcoders.model.Plateau;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private State state;
    private Scanner scanner;
    private MissionControl missionControl;

    public UI() {
        state = State.WELCOME;
        scanner = new Scanner(System.in);
    }

    public State welcome(){
        System.out.println("WELCOME TO MARS: ");
        System.out.println("It's your first day at Mission Control so you have been given access to a top of the range deploy rover simulator!");
        System.out.println("Start by entering the size of the plateau you wish to work with and then land your first rover...");

        return State.PLATEAU_SETUP;
    }

    public State setUpPlateau(){
        while(true){
            try{
                System.out.println("Enter the size of your simulated Plateau. Use the format 'X Y': both values must be whole positive numbers.");
                String input = scanner.nextLine();

                PlateauParser plateauParser = new PlateauParser();
                Plateau plateau = plateauParser.parsePlateauInput(input);

                missionControl = new MissionControl(plateau);
                return State.ADD_ROVER;

            } catch (IllegalArgumentException e){
                System.out.println((e.getMessage()));
            }
        }
    }

}
