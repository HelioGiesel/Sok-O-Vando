package org.academiadecodigo.asynctomatics.sokovando;

import org.academiadecodigo.asynctomatics.sokovando.elements.*;
import org.academiadecodigo.asynctomatics.sokovando.exceptions.WinningException;

import java.util.LinkedList;

public class CollisionDetector {

    public static boolean isColliding(Position[] gameObjects, Position movingObject, Directions direction) throws WinningException {

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

    public static void checkSpots(Position[] gameObjects) throws WinningException {

        //run through array, collect spots and boxes, check if they are on same position

        LinkedList<Position> spotList = new LinkedList<>();
        LinkedList<Position> boxList = new LinkedList<>();

        for (Position element : gameObjects) {

            if (element instanceof Box) boxList.add(element);
            if (element instanceof Spot) spotList.add(element);

        }

        int validation = 0;

        for (Position box : boxList) {
            for (Position spot : spotList) {
                if ((box.getY() == spot.getY()) && (box.getX() == spot.getX())) validation++;
            }
        }

        if ((validation == spotList.size()) && (validation != 0)) {
            System.out.println("Ganhou modafoca!!!!!");

            for (int i = 0; i < gameObjects.length; i++) gameObjects[i].deleteShape();

            throw new WinningException();

        }
    }
}


