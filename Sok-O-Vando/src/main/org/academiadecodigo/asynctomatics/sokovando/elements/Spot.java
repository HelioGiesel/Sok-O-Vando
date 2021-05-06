package org.academiadecodigo.asynctomatics.sokovando.elements;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Spot extends Position {

    Picture spotShape;

    public Spot(int x, int y) {
        super(x, y);

        spotShape = new Picture(x, y, "resources/vandoIcon.png");
        spotShape.draw();
    }


    @Override
    public void deleteShape() {
        this.spotShape.delete();
    }
}
