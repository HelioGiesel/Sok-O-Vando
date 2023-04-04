package org.academiadecodigo.asynctomatics.sokovando.elements;

import org.academiadecodigo.asynctomatics.sokovando.controlls.Directions;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player extends Position {

    Picture playerShape;
    String imageResourcePath;

    public Player(int x, int y) {
        super(x, y);
        imageResourcePath = "resources/playerDownIcon.png";
    }

    public void drawPlayer() {
        this.playerShape = super.initShape(imageResourcePath);
    }

    public void setPlayerIconDirection(Directions direction) {
        deleteShape();

        switch (direction) {
            case UP:
                imageResourcePath = "resources/playerUpIcon.png";
                break;

            case LEFT:
                imageResourcePath = "resources/playerLeftIcon.png";
                break;

            case RIGHT:
                imageResourcePath = "resources/playerRightIcon.png";
                break;

            default:
                imageResourcePath = "resources/playerDownIcon.png";
                break;
        }

        drawPlayer();
    }
}
