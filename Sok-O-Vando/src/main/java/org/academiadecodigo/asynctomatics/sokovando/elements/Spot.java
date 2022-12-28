package org.academiadecodigo.asynctomatics.sokovando.elements;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Spot extends Position {
    public Spot(int x, int y) {
        super(x, y);
        super.initShape("resources/vandoIcon.png");
    }
}
