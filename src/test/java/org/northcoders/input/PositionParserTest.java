package org.northcoders.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.northcoders.model.CompassDirection;
import org.northcoders.model.Position;

import static org.junit.jupiter.api.Assertions.*;

class PositionParserTest {

    @Test
    @DisplayName("Parse starting position returns a position instance using the values given in the input string.")
    void parseStartingPosition() {
        PositionParser positionParser = new PositionParser();
        Position expectedOutput = new Position(5 , 5, CompassDirection.N);

        assertEquals(expectedOutput, positionParser.parseStartingPosition("5 5 N"));
    }

    @Test
    @DisplayName("Parse starting position returns a position instance using the values given in the input string even when compass direction is given as lower case.")
    void parseStartingPositionWithLowerCaseCompassDirection() {
        PositionParser positionParser = new PositionParser();
        Position expectedOutput = new Position(5 , 5, CompassDirection.N);

        assertEquals(expectedOutput, positionParser.parseStartingPosition("5 5 n"));
    }
}