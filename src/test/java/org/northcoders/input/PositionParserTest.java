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

    @Test
    @DisplayName("Parse starting position returns a position instance using the values given in the input string even when additional spaces are used.")
    void parseStartingPositionWithAdditionalSpaces() {
        PositionParser positionParser = new PositionParser();
        Position expectedOutput = new Position(5 , 5, CompassDirection.N);

        assertEquals(expectedOutput, positionParser.parseStartingPosition("5 5  n"));
    }

    @Test
    @DisplayName("Parse starting position throws an error if format of int int string equivalent of a compass direction isn't used.")
    void parseStartingPositionThrowsErrorWhenInputDoesNotFollowRequestedFormat() {
        PositionParser positionParser = new PositionParser();

        assertThrows(IllegalArgumentException.class, () -> positionParser.parseStartingPosition("5 n  n"));
        assertThrows(IllegalArgumentException.class, () -> positionParser.parseStartingPosition("5 5 Z"));
        assertThrows(IllegalArgumentException.class, () -> positionParser.parseStartingPosition("5 5 5"));
        assertThrows(IllegalArgumentException.class, () -> positionParser.parseStartingPosition("5 5"));
        assertThrows(IllegalArgumentException.class, () -> positionParser.parseStartingPosition("N"));
        assertThrows(IllegalArgumentException.class, () -> positionParser.parseStartingPosition(""));
        assertThrows(IllegalArgumentException.class, () -> positionParser.parseStartingPosition(" "));
    }
}