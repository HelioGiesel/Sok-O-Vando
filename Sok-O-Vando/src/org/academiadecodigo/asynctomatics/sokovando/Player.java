package org.academiadecodigo.asynctomatics.sokovando;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player extends Position {

    Picture playerShape;


    Position[] level;


    public Player(int x, int y){
        super(x,y);

        Picture playerShape = new Picture(x,y,"resources/playerDownIcon.png");
        playerShape.draw();

        this.playerShape = playerShape;
    }

    @Override
    public void drawIcon(){
        playerShape.draw();
    }

    @Override
    public void deleteIcon() {
        playerShape.delete();
    }

    public Picture getPlayerDownIcon(int x, int y){
        return new Picture(x,y, "resources/playerDownIcon.png");
    }

    public Picture getPlayerUpIcon(int x, int y){
        return new Picture(x,y, "resources/playerUpIcon.png");
    }

    public Picture getPlayerRightIcon(int x, int y){
        return new Picture(x,y, "resources/playerRightIcon.png");
    }

    public Picture getPlayerLeftIcon(int x, int y){
        return new Picture(x,y, "resources/playerLeftIcon.png");
    }


    public void checkMove(Directions direction, Position[] level){

        this.level = level;

        Player ghostPosition = new Player(playerShape.getX(), playerShape.getY());

        boolean canMove = false;

        switch (direction){
            case UP:
                ghostPosition.setY(getY() - CELLSIZE);
                canMove = !(CollisionDetector.isColliding(level , ghostPosition, direction));
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
        //System.out.println(canMove);
        ghostPosition.playerShape.delete();

        if (canMove) this.move(direction);
    }

    public void move(Directions direction){
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

        playerShape.delete();
        playerShape = new Picture(getX(),getY(),"resources/playerDownIcon.png");
        playerShape.draw();

       // System.out.printf(super.getX() + " x and y " + getY());
    }
}
