package org.northcoders.input;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.northcoders.model.Instruction;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

public class InstructionParserTest {


    @Test
    @DisplayName("Parse instructions returns queue of instruction enums equivalent to string passed in")
    public void parseInstructions() {
        InstructionParser instructionParser = new InstructionParser();
        Queue<Instruction> expectedResult = new LinkedList<>();

        expectedResult.add(Instruction.L);
        expectedResult.add(Instruction.R);
        expectedResult.add(Instruction.M);

        assertEquals(expectedResult, instructionParser.parseInstructions("LRM"));
    }

    @Test
    @DisplayName("Parse instructions returns queue of instruction enums equivalent to lower case string passed in")
    public void parseInstructionsFromLowerCase() {
        InstructionParser instructionParser = new InstructionParser();
        Queue<Instruction> expectedResult = new LinkedList<>();

        expectedResult.add(Instruction.L);
        expectedResult.add(Instruction.R);
        expectedResult.add(Instruction.M);

        assertEquals(expectedResult, instructionParser.parseInstructions("lrm"));
    }

    @Test
    @DisplayName("Parse instructions returns queue of instruction enums equivalent to string passed in despite spaces")
    public void parseInstructionsWithSpacesInString() {
        InstructionParser instructionParser = new InstructionParser();
        Queue<Instruction> expectedResult = new LinkedList<>();

        expectedResult.add(Instruction.L);
        expectedResult.add(Instruction.R);
        expectedResult.add(Instruction.M);

        assertEquals(expectedResult, instructionParser.parseInstructions("L R M"));
    }
}