package org.northcoders.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
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

        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> positionParser.parseStartingPosition("5 N  N")),
                () -> assertThrows(IllegalArgumentException.class, () -> positionParser.parseStartingPosition("5 5N  N")),
                () -> assertThrows(IllegalArgumentException.class, () -> positionParser.parseStartingPosition("555   N")),
                () -> assertThrows(IllegalArgumentException.class, () -> positionParser.parseStartingPosition("5 5 Z")),
                () -> assertThrows(IllegalArgumentException.class, () -> positionParser.parseStartingPosition("5 5 5")),
                () -> assertThrows(IllegalArgumentException.class, () -> positionParser.parseStartingPosition("5 5")),
                () -> assertThrows(IllegalArgumentException.class, () -> positionParser.parseStartingPosition("N")),
                () -> assertThrows(IllegalArgumentException.class, () -> positionParser.parseStartingPosition("")),
                () -> assertThrows(IllegalArgumentException.class, () -> positionParser.parseStartingPosition(" "))
        );
    }

    @Test
    @DisplayName("Parse starting position is not impacted by whitespace inconsistencies.")
    void parseStartingPositionIsNotImpactedByWhitespace() {
        PositionParser positionParser = new PositionParser();
        Position expectedOutput = new Position(5 , 5, CompassDirection.N);

        assertAll(
                () -> assertEquals(expectedOutput, positionParser.parseStartingPosition("5  5 N")),
                () -> assertEquals(expectedOutput, positionParser.parseStartingPosition("5 5  N")),
                () -> assertEquals(expectedOutput, positionParser.parseStartingPosition(" 5 5 N")),
                () -> assertEquals(expectedOutput, positionParser.parseStartingPosition("5 5 N "))
        );
    }

}