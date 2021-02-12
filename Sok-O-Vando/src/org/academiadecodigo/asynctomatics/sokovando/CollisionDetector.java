package org.academiadecodigo.asynctomatics.sokovando;

public class CollisionDetector {

    public static boolean isColliding(Position[] gameObjects, Position movingObject, Directions direction){

        for (Position obstacle : gameObjects) {

            if (obstacle != null) {

                if ((obstacle.getX() == movingObject.getX()) && (obstacle.getY() == movingObject.getY())) {

                    if (obstacle instanceof Wall) return true;

                    if ((movingObject instanceof Box) && (obstacle instanceof Box)) return true;

                    if ((movingObject instanceof Player) && (obstacle instanceof Box)) {

                        return (!((Box) obstacle).checkMove(direction, gameObjects));

                    }
                }
            }

        }

        return false;
    }

}
