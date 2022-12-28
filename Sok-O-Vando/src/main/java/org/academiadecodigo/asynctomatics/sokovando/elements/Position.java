package org.academiadecodigo.asynctomatics.sokovando.elements;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Position {

    public static final int CELLSIZE = 50;
    private Picture elementShape;
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int newX) {
        this.x = newX;
    }

    public void setY(int newY) {
        this.y = newY;
    }

    public Picture initShape(String elementShapeReference) {
        this.elementShape = new Picture(x, y, elementShapeReference);
        this.elementShape.draw();
        return this.elementShape;
    }

    public void deleteShape() {
        this.elementShape.delete();
    };

}
