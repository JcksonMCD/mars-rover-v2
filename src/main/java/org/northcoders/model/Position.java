package org.northcoders.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Position {
    private int x;
    private int y;
    private CompassDirection facing;
}
