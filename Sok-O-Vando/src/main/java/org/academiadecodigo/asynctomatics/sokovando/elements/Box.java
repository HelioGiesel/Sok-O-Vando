
package org.academiadecodigo.asynctomatics.sokovando.elements;

import org.academiadecodigo.asynctomatics.sokovando.CollisionDetector;
import org.academiadecodigo.asynctomatics.sokovando.Directions;
import org.academiadecodigo.asynctomatics.sokovando.exceptions.WinningException;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Box extends Position {


    Picture boxShape;

    public Box(int x, int y) {
        super(x, y);

        boxShape = new Picture(x, y, "resources/jsIcon.png");
        boxShape.draw();

    }

    @Override
    public void deleteShape() {
        boxShape.delete();
    }

    public boolean checkMove(Directions direction, Position[] level) throws WinningException {

        Box ghostPosition = new Box(boxShape.getX(), boxShape.getY());

        boolean canMove = false;

        switch (direction) {
            case UP:
                ghostPosition.setY(getY() - CELLSIZE);
                canMove = !(CollisionDetector.isColliding(level, ghostPosition, direction));
                break;
            case DOWN:
                ghostPosition.setY(getY() + CELLSIZE);
                canMove = !(CollisionDetector.isColliding(level, ghostPosition, direction));
                break;
            case LEFT:
                ghostPosition.setX(getX() - CELLSIZE);
                canMove = !(CollisionDetector.isColliding(level, ghostPosition, direction));
                break;
            case RIGHT:
                ghostPosition.setX(getX() + CELLSIZE);
                canMove = !(CollisionDetector.isColliding(level, ghostPosition, direction));
                break;
        }

        ghostPosition.boxShape.delete();

        if (canMove) this.move(direction, level);

        return canMove;

    }

    public void move(Directions direction, Position[] level) throws WinningException {
        switch (direction) {
            case UP:
                this.setY(getY() - CELLSIZE);
                break;
            case DOWN:
                this.setY(getY() + CELLSIZE);
                break;
            case LEFT:
                this.setX(getX() - CELLSIZE);
                break;
            case RIGHT:
                this.setX(getX() + CELLSIZE);
                break;
        }

        boxShape.delete();
        boxShape = new Picture(getX(), getY(), "resources/jsIcon.png");
        boxShape.draw();

        CollisionDetector.checkSpots(level);
    }

}
