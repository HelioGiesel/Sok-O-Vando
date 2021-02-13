package org.academiadecodigo.asynctomatics.sokovando;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Spot extends Position {

    Picture spotShape;

    Spot(int x, int y) {
        super(x, y);

        spotShape = new Picture(x, y, "resources/vandoIcon.png");

    }

    @Override
    public void drawIcon(){
        spotShape.draw();
    }

    @Override
    public void deleteIcon() {
        spotShape.delete();
    }
}
