package org.academiadecodigo.asynctomatics.sokovando;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Wall extends Position {

    Picture wallShape;

    Wall(int x, int y){
        super(x, y);

        wallShape = new Picture(x, y, "resources/wall_Icon.png");
        wallShape.draw();
    }

    @Override
    public void deleteShape() {
        this.wallShape.delete();
    }
}
