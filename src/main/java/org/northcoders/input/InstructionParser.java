package org.northcoders.input;

import org.northcoders.model.Instruction;

import java.util.LinkedList;
import java.util.Queue;

public class InstructionParser {

    public Queue<Instruction> parseInstructions(String instructionsInput){
        Queue<Instruction> parsedInstructions = new LinkedList<>();

        for (String instruction : instructionsInput.split("")){
            parsedInstructions.add(Instruction.valueOf(instruction.toUpperCase()));
        }

        return parsedInstructions;
    }
}
