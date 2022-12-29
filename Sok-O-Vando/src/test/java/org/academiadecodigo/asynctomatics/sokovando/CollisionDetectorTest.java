package org.academiadecodigo.asynctomatics.sokovando;

import org.academiadecodigo.asynctomatics.sokovando.controlls.Directions;
import org.academiadecodigo.asynctomatics.sokovando.elements.*;
import org.academiadecodigo.asynctomatics.sokovando.exceptions.WinningException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CollisionDetectorTest {
    private Player player;
    private Box movableBox;
    private Spot spot;
    private final Position[] level = new Position[5];
    private final int cellSize = Position.CELLSIZE;
    private final int initialPositionX = cellSize;
    private final int initialPositionY = cellSize;

    @Before
    public void setup() {
        player = new Player(initialPositionX, initialPositionY);
        movableBox = new Box(initialPositionX + cellSize, initialPositionY);
        spot = new Spot(initialPositionX * 3, initialPositionY * 3);
        // box at right
        level[0] = this.movableBox;
        // 2 box at bottom
        level[1] = new Box(initialPositionX, initialPositionY + cellSize);
        level[2] = new Box(initialPositionX, initialPositionY + (cellSize * 2));
        // wall at left
        level[3] = new Wall(initialPositionX - cellSize, initialPositionY);
        // spot to avoid winning exception
        level[4] = spot;
    }

    @Test
    public void isCollidingShallReturnFalseIfNoObstaclesHit() throws WinningException {
        // given
        player.setY(initialPositionY - cellSize);

        // when
        boolean result = CollisionDetector.isColliding(level, player, Directions.UP);

        // then
        assertFalse(result);
    }

    @Test
    public void isCollidingShallReturnFalseIfPlayerHitMovableBox() throws WinningException {
        // given
        player.setX(initialPositionX + cellSize);

        // when
        boolean result = CollisionDetector.isColliding(level, player, Directions.RIGHT);

        // then
        assertFalse(result);
    }

    @Test
    public void isCollidingShallReturnTrueIfPlayerHitUnmovableBox() throws WinningException {
        // given
        player.setY(initialPositionY + cellSize);

        // when
        boolean result = CollisionDetector.isColliding(level, player, Directions.DOWN);

        // then
        System.out.println(result);
        assertTrue(result);
    }
    @Test
    public void isCollidingShallReturnTrueIfHitWall() throws WinningException {
        // given
        player.setX(initialPositionX - cellSize);

        // when
        boolean result = CollisionDetector.isColliding(level, player, Directions.LEFT);

        // then
        assertTrue(result);
    }

    @Test
    public void checkSpotsShallThrowExceptionWhenAllSpotsHaveBoxes() {
        // given
        movableBox.setX(spot.getX());
        movableBox.setY(spot.getY());
        boolean result = false;

        // when
        try {
            CollisionDetector.checkSpots(level);
        } catch(WinningException exception) {
            result = true;
        }

        // then
        assertTrue(result);
    }

    @Test
    public void checkSpotsShallNotThrowExceptionWhenNotAllSpotsHaveBoxes() {
        // given
        boolean result = false;

        // when
        try {
            CollisionDetector.checkSpots(level);
        } catch(WinningException exception) {
            result = true;
        }

        // then
        assertFalse(result);
    }
}
