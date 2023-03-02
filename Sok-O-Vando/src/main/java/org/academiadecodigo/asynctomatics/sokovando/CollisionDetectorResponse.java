package org.academiadecodigo.asynctomatics.sokovando;

import org.academiadecodigo.asynctomatics.sokovando.elements.Position;

public class CollisionDetectorResponse {
    public boolean playerCanMove = false;
    public boolean nextObstacleCanMove = false;
    public Position nextObstacle;

    public void setBoxCanMoveScenario(Position box) {
        playerCanMove = true;
        nextObstacleCanMove = true;
        nextObstacle = box;
    }
}
