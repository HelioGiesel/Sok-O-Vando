package org.academiadecodigo.asynctomatics.sokovando;

public class Player {

    private String name;

    public Player(String name) {
        this.name = name;
    }

    public boolean checkEdges() {
        return true;
    }

    public void move() {

    }

    public boolean isSpot() {
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

}
