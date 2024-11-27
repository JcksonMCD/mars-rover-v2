package org.northcoders.input;

import org.northcoders.model.Instruction;

import java.util.LinkedList;
import java.util.Queue;

public class InstructionParser {

    public Queue<Instruction> parseInstructions(String instructionsInput){
        if (instructionsInput == null) throw new IllegalArgumentException();

        Queue<Instruction> parsedInstructions = new LinkedList<>();

        for (String instruction : instructionsInput.replaceAll(" ", "").split("")){
            parsedInstructions.add(Instruction.valueOf(instruction.toUpperCase()));
        }

        return parsedInstructions;
    }
}
