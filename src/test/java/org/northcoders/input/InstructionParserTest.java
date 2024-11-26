package org.northcoders.input;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

public class InstructionParserTest {

    @Test
    @DisplayName("Parse instructions returns queue of instruction enums equivalent to string passed")
    public void parseInstructions() {
        InstructionParser instructionParser = new InstructionParser();
        Queue<Instruction> expectedResult = new LinkedList<>();

        expectedResult.add(Instruction.L);
        expectedResult.add(Instruction.R);
        expectedResult.add(Instruction.M);

        assertEquals(expectedResult, instructionParser.parseInstructions("LRM"));
    }
}