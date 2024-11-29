package org.northcoders.ui;

import org.northcoders.MissionControl;

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



}
