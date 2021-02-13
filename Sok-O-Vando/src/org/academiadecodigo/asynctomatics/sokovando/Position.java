package org.academiadecodigo.asynctomatics.sokovando;

public abstract class Position {
    public static final int CELLSIZE = 50;
    private int x;
    private int y;
    private final int startX;
    private final int startY;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
        startX = x;
        startY = y;
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

    ;

    public void setY(int newY) {
        this.y = newY;
    }

    ;

    public abstract void drawIcon();

    public abstract void deleteIcon();

    public void resetPos() {
        this.x = startX;
        this.y = startY;

    }
}
