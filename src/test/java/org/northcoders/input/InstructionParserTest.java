package org.northcoders.input;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.northcoders.model.Instruction;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class InstructionParserTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

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

    @Test
    @DisplayName("Parse instructions throws error if passed letters that are not L/M/R")
    public void parseInstructionsPrintsStatementIfPassedIncorrectLetters() {
        InstructionParser instructionParser = new InstructionParser();

        assertThrows(IllegalArgumentException.class, () -> instructionParser.parseInstructions("Z"));
    }

}