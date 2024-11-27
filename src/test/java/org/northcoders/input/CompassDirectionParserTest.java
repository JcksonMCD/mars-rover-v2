package org.northcoders.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.northcoders.model.CompassDirection;

import static org.junit.jupiter.api.Assertions.*;

class CompassDirectionParserTest {

    @Test
    @DisplayName("Compass direction parser takes an input of a single compass direction and parses it to the enum type compass direction")
    void compassDirectionParser() {
        CompassDirectionParser directionParser = new CompassDirectionParser();

        assertAll(
                () -> assertEquals(CompassDirection.N, directionParser.compassDirectionParser("N")),
                () -> assertEquals(CompassDirection.N, directionParser.compassDirectionParser("E")),
                () -> assertEquals(CompassDirection.N, directionParser.compassDirectionParser("S")),
                () -> assertEquals(CompassDirection.N, directionParser.compassDirectionParser("W"))
        );
    }
}