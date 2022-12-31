package org.academiadecodigo.asynctomatics.sokovando.elements;

import org.academiadecodigo.asynctomatics.sokovando.controlls.Directions;
import org.academiadecodigo.asynctomatics.sokovando.exceptions.WinningException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PlayerTest {
    private Player player;
    private Box movableBox;
    private final ArrayList<Position> level = new ArrayList<>();
    private final int cellSize = Position.CELLSIZE;
    private final int initialPositionX = cellSize;
    private final int initialPositionY = cellSize;

    @Before
    public void setup() {
        this.player = new Player(initialPositionX, initialPositionY);
        this.movableBox = new Box(initialPositionX + cellSize, initialPositionY);
        level.add(player);
        // box at right
        level.add(movableBox);
        // 2 box at bottom
        level.add(new Box(initialPositionX, initialPositionY + cellSize));
        level.add(new Box(initialPositionX, initialPositionY + (cellSize * 2)));
        // wall at left
        level.add(new Wall(initialPositionX - cellSize, initialPositionY));
    }

    @Test
    public void checkMoveShallMoveIfNoObstacleAhead() throws WinningException {
        // when
        player.checkMove(Directions.UP, level);

        // then
        assertEquals(player.getX(), initialPositionX);
        assertEquals(player.getY(), initialPositionY - cellSize);
    }

    @Test
    public void checkMoveShallMoveIfHitBoxWithNoObstacleAhead() throws WinningException {
        // when
        player.checkMove(Directions.RIGHT, level);

        // then
        assertEquals(player.getX(), initialPositionX + cellSize);
        assertEquals(player.getY(), initialPositionY);
        assertEquals(movableBox.getX(), initialPositionX + (2 * cellSize));
        assertEquals(movableBox.getY(), initialPositionY);
    }

    @Test
    public void checkMoveShouldNotMoveIfBoxAheadHitObstacle() throws WinningException {
        // when
        player.checkMove(Directions.DOWN, level);

        // then
        assertEquals(player.getX(), initialPositionX);
        assertEquals(player.getY(), initialPositionY);
    }

    @Test
    public void checkMoveShouldNotMoveIfHitWall() throws WinningException {
        // when
        player.checkMove(Directions.LEFT, level);

        // then
        assertEquals(player.getX(), initialPositionX);
        assertEquals(player.getY(), initialPositionY);
    }
}
