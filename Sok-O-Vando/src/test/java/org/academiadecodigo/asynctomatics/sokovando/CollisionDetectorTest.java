package org.academiadecodigo.asynctomatics.sokovando;

import org.academiadecodigo.asynctomatics.sokovando.controlls.Directions;
import org.academiadecodigo.asynctomatics.sokovando.elements.*;
import org.academiadecodigo.asynctomatics.sokovando.exceptions.WinningException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class CollisionDetectorTest {
    private Player player;
    private Box movableBox;
    private Spot spot;
    private HashMap<String, ArrayList<Position>> levelElementsMap = new HashMap<>();
    private CollisionDetector collisionDetector;
    private final ArrayList<Position> boxes = new  ArrayList<>();
    private final ArrayList<Position> walls = new  ArrayList<>();
    private final ArrayList<Position> spots = new  ArrayList<>();
    private final int cellSize = Position.CELLSIZE;
    private final int initialPositionX = cellSize;
    private final int initialPositionY = cellSize;

    @Before
    public void setup() {

        player = new Player(initialPositionX, initialPositionY);
        // spot to avoid winning
        spot = new Spot(initialPositionX * 3, initialPositionY * 3);
        spots.add(spot);
        // box at right
        movableBox = new Box(initialPositionX + cellSize, initialPositionY);
        boxes.add(movableBox);
        // 2 box at bottom
        boxes.add(new Box(initialPositionX, initialPositionY + cellSize));
        boxes.add(new Box(initialPositionX, initialPositionY + (cellSize * 2)));
        // wall at left
        walls.add(new Wall(initialPositionX - cellSize, initialPositionY));

        levelElementsMap.put("boxes", boxes);
        levelElementsMap.put("spots", spots);
        levelElementsMap.put("walls", walls);

        collisionDetector = new CollisionDetector(new Game(), levelElementsMap, player);
    }

    @Test
    public void collisionResponseShallReturnTrueForPlayerMoveWhenNotColliding() {
        // given
        player.setY(initialPositionY - cellSize);

        // when
        CollisionDetectorResponse result = collisionDetector.checkMovement(Directions.UP);

        // then
        assertTrue(result.playerCanMove);
    }

    @Test
    public void collisionResponseShallReturnTrueForMovementsWhenHittingMovableBox() {
        // given
        player.setX(initialPositionX + cellSize);

        // when
        CollisionDetectorResponse result = collisionDetector.checkMovement(Directions.RIGHT);

        // then
        assertTrue(result.playerCanMove);
        assertTrue(result.nextObstacleCanMove);
        assertNotNull(result.nextObstacle);
    }

    @Test
    public void collisionResponseShallReturnFalseForMovementIfHitUnmovableBox() throws WinningException {
        // given
        player.setY(initialPositionY + cellSize);

        // when
        CollisionDetectorResponse result = collisionDetector.checkMovement(Directions.DOWN);

        // then
        assertFalse(result.playerCanMove);
    }
    @Test
    public void collisionResponseShallReturnFalseForMovementIfHitWall() throws WinningException {
        // given
        player.setX(initialPositionX - cellSize);

        // when
        CollisionDetectorResponse result = collisionDetector.checkMovement(Directions.LEFT);

        // then
        assertFalse(result.playerCanMove);
    }
}
