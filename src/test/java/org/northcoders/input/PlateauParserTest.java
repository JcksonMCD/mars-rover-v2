package org.northcoders.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.northcoders.model.Plateau;
import org.northcoders.model.Position;

import static org.junit.jupiter.api.Assertions.*;

class PlateauParserTest {

    @Test
    @DisplayName("When provided with two space separated ints a plateau of that size is returned.")
    void parsePlateauInput() {
        PlateauParser plateauParser = new PlateauParser();
        Plateau expectedOutput = new Plateau(5, 5);

        assertEquals(expectedOutput, plateauParser.parsePlateauInput("5 5"));
    }

    @Test
    @DisplayName("When provided with two ints with multiple spaces in between a plateau of that size is returned.")
    void parsePlateauInputMultipleSpacesSeperatingInts() {
        PlateauParser plateauParser = new PlateauParser();
        Plateau expectedOutput = new Plateau(5, 5);

        assertEquals(expectedOutput, plateauParser.parsePlateauInput("5  5"));
    }

    @Test
    @DisplayName("When provided with two ints with trailing whitespace a plateau of that size is returned.")
    void parsePlateauInputNotAffectedByTrailingWhitespace() {
        PlateauParser plateauParser = new PlateauParser();
        Plateau expectedOutput = new Plateau(5, 5);

        assertAll(
                () -> assertEquals(expectedOutput, plateauParser.parsePlateauInput("5 5 ")),
                () -> assertEquals(expectedOutput, plateauParser.parsePlateauInput(" 5 5")),
                () -> assertEquals(expectedOutput, plateauParser.parsePlateauInput(" 5 5 "))
        );

    }

    @Test
    @DisplayName("Incorrect format for input throws IllegalArgumentException.")
    void parsePlateauInputWithIncorrectInputThrowsException() {
        PlateauParser plateauParser = new PlateauParser();

        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> plateauParser.parsePlateauInput("Z Z")),
                () -> assertThrows(IllegalArgumentException.class, () -> plateauParser.parsePlateauInput("5 Z")),
                () -> assertThrows(IllegalArgumentException.class, () -> plateauParser.parsePlateauInput("5 5 5"))
        );

    }
}