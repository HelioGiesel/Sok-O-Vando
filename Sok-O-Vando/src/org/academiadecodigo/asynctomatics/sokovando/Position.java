package org.academiadecodigo.asynctomatics.sokovando;

public abstract class Position {

    private int x;
    private int y;
    private int width;
    private int height;
    private boolean box;
    private boolean spot;
    private boolean player;


    public Position(int x, int y, int width, int height){
        this.x= x;
        this.y= y;
        this.width = width;
        this.height = height;
        box= false;
        spot= false;
        player = false;

    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public boolean isBox(){
        return box;
    }
    public boolean isSpot(){
        return spot;
    }
    public boolean isPlayer(){
        return player;
    }


}
