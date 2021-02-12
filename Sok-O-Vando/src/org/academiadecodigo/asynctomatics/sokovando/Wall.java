package org.academiadecodigo.asynctomatics.sokovando;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Wall extends Position {

    Rectangle wallShape;

    Wall(int x, int y){
        super(x, y);

        wallShape = new Rectangle(x, y, CELLSIZE, CELLSIZE);

        wallShape.setColor(Color.LIGHT_GRAY);
        wallShape.draw();

        wallShape.setColor(Color.DARK_GRAY);
        wallShape.fill();
    }
}