package org.northcoders.ui;

import org.northcoders.MissionControl;

import java.util.Scanner;

public class UI {
    private State state;
    private Scanner scanner;
    private MissionControl missionControl;

    public UI() {
        state = State.PLATEAU_SETUP;
        scanner = new Scanner(System.in);
    }
}
