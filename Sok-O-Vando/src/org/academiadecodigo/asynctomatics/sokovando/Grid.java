package org.academiadecodigo.asynctomatics.sokovando;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {

        private final int cellSize;
        private int width;
        private int heigth;
        private Rectangle canvas;


        public Grid(int cellSize, int width, int heigth) {
                this.cellSize = cellSize;
                this.width = width;
                this.heigth = heigth;

                Rectangle grid = new Rectangle(10, 10, 200, 200);

                Picture picture =  new Picture(); //Test to understand how to introduce pictures


                grid.setColor(Color.MAGENTA);
                grid.fill();



        }



}
