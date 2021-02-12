package org.academiadecodigo.asynctomatics.sokovando;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Box extends Position {

    Rectangle boxShape;
    Picture icon;


    public Box(int x, int y){
        super(x, y);

        boxShape = new Rectangle(x, y, CELLSIZE, CELLSIZE);

        boxShape.setColor(Color.YELLOW);
        boxShape.fill();

    }

    public boolean checkMove(Directions direction, Position[] level){

        Box ghostPosition = new Box(boxShape.getX(), boxShape.getY());

        boolean canMove = false;

        switch (direction){
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

    public void move(Directions direction, Position[] level){
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
        boxShape = new Rectangle(getX(),getY(),CELLSIZE,CELLSIZE);
        boxShape.setColor(Color.YELLOW);
        boxShape.fill();

        CollisionDetector.checkSpots(level);
    }

}
