package org.academiadecodigo.asynctomatics.sokovando.elements;

import org.academiadecodigo.asynctomatics.sokovando.controlls.Directions;
import org.academiadecodigo.asynctomatics.sokovando.exceptions.WinningException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoxTest {
    private Box box;
    private final Position[] level = new Position[5];
    private final int cellSize = Position.CELLSIZE;
    private final int initialPositionX = cellSize;
    private final int initialPositionY = cellSize;
    private boolean result;
    @Before
    public void setup() {
        // given
        this.box = new Box(initialPositionX,initialPositionY);
        level[0] = this.box;
        level[1] = new Box(initialPositionX + cellSize, initialPositionY);
        level[2] = new Wall(initialPositionX - cellSize, initialPositionY);
        level[3] = new Spot(initialPositionX, initialPositionY + cellSize);
        level[4] = new Spot(initialPositionX, initialPositionY + (2 * cellSize));
    }
    @Test
    public void checkMoveShallReturnTrueIfNoObstacleHit() throws WinningException {
        // when
        result = box.checkMove(Directions.UP, level);

        // then
        assertTrue(result);
        assertEquals(box.getX(), initialPositionX);
        assertEquals(box.getY(), initialPositionY - cellSize);
    }

    @Test
    public void checkMoveShallReturnFalseIfHitWall() throws WinningException {
        // when
        result = box.checkMove(Directions.LEFT, level);

        // then
        assertFalse(result);
        assertEquals(box.getX(), initialPositionX);
        assertEquals(box.getY(), initialPositionY);
    }

    @Test
    public void checkMoveShallReturnFalseIfBoxAhead() throws WinningException {
        // when
        result = box.checkMove(Directions.RIGHT, level);

        // then
        assertFalse(result);
        assertEquals(box.getX(), initialPositionX);
        assertEquals(box.getY(), initialPositionY);
    }

    @Test
    public void checkMoveShallReturnTrueIfSpotAhead() throws WinningException {
        // when
        result = box.checkMove(Directions.DOWN, level);

        // then
        assertTrue(result);
        assertEquals(box.getX(), initialPositionX);
        assertEquals(box.getY(), initialPositionY + cellSize);
    }
}
