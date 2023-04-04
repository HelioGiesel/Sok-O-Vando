package org.academiadecodigo.asynctomatics.sokovando.controlls;

import org.academiadecodigo.asynctomatics.sokovando.elements.GenericPosition;
import org.academiadecodigo.asynctomatics.sokovando.elements.Position;

import java.util.ArrayList;

public enum Directions {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    public static void setPositionNextCoordinatesByDirection(Position coordinates, Directions direction, int steps) {
        if (direction == UP) coordinates.setY(coordinates.getY() - (Position.CELLSIZE * steps));
        if (direction == DOWN) coordinates.setY(coordinates.getY() + (Position.CELLSIZE * steps));
        if (direction == LEFT) coordinates.setX(coordinates.getX() - (Position.CELLSIZE * steps));
        if (direction == RIGHT) coordinates.setX(coordinates.getX() + (Position.CELLSIZE * steps));
    }

    public static void translatePositionShape(Position position, Directions direction) {
        if (direction == UP) position.getShape().translate(0, -Position.CELLSIZE);
        if (direction == DOWN) position.getShape().translate(0, Position.CELLSIZE);
        if (direction == LEFT) position.getShape().translate(-Position.CELLSIZE, 0);
        if (direction == RIGHT) position.getShape().translate(Position.CELLSIZE, 0);
    }
}
