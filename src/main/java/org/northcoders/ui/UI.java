package org.northcoders.ui;

import org.northcoders.MissionControl;
import org.northcoders.input.InstructionParser;
import org.northcoders.input.PlateauParser;
import org.northcoders.input.PositionParser;
import org.northcoders.model.Instruction;
import org.northcoders.model.Plateau;
import org.northcoders.model.Position;
import org.northcoders.model.Rover;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class UI {
    private State state;
    private Scanner scanner;
    private MissionControl missionControl;
    private Rover currentRover;

    public UI() {
        state = State.WELCOME;
        scanner = new Scanner(System.in);
    }

    public void start(){
        while (state != State.END){
            switch (state){
                case WELCOME -> state = welcome();
                case PLATEAU_SETUP -> state = setUpPlateau();
                case ADD_ROVER -> state = addRover();
                case GIVE_ROVER_INSTRUCTIONS -> state = inputInstructions();
            }
        }

        System.out.println("Rovers finished at locations: ");
        missionControl.getRovers().forEach(r -> System.out.println(r.getPosition().getX() + " " +
                + r.getPosition().getY() + " " + r.getPosition().getFacing()));
        System.out.println("Great job!!");
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

    public State addRover(){
        while (true){
            try{
                System.out.println("Enter you rovers starting coordinates. Use the format 'X Y N/E/S/W': Position must be within your plateau bounds.");
                String input = scanner.nextLine();

                PositionParser positionParser = new PositionParser();
                Position position = positionParser.parseStartingPosition(input);

                Rover rover = new Rover(position);
                missionControl.addRover(rover);
                this.currentRover = rover;

                return State.GIVE_ROVER_INSTRUCTIONS;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public State inputInstructions(){
        while (true){
            try {
                System.out.println("Enter your rover movement instructions. " +
                        "You are able to use: \n1) 'L' : Rotate rover left " +
                        "\n2) 'R' : Rotate rover right \n3) 'M' : Move forward one space");
                String input = scanner.nextLine();

                InstructionParser instructionParser = new InstructionParser();
                Queue<Instruction> instructions = instructionParser.parseInstructions(input);

                missionControl.executeRoverInstructions(instructions, this.currentRover);
                printRoverPosition();

                System.out.println("\nDo you want to add a new rover. Type Y for yes.");
                input = scanner.nextLine();

                return input.equalsIgnoreCase("Y") ? State.ADD_ROVER : State.END;

            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void printRoverPosition(){
        System.out.printf("The current position of your rover is: %d %d %s",
                currentRover.getPosition().getX(),
                currentRover.getPosition().getY(),
                currentRover.getPosition().getFacing());
    }

}
