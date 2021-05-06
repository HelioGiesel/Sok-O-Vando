package org.academiadecodigo.asynctomatics.sokovando.elements;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Wall extends Position {

    Picture wallShape;

    public Wall(int x, int y){
        super(x, y);

        wallShape = new Picture(x, y, "resources/wall_Icon.png");
        wallShape.draw();
    }

    @Override
    public void deleteShape() {
        this.wallShape.delete();
    }
}
