package org.academiadecodigo.asynctomatics.sokovando;

import java.util.Scanner;

public class Player {

    private String name;
    private Position pos;

    public Player(Position pos) {
        this.pos = pos;
    }

    public boolean receiveMove(Direction direction) {
        if (!checkEdges.player(pos.move(direction)) && (!checkEdges.wall(pos.move(direction))) && (!checkEdges.box(pos.move(direction)))) {
            pos.move(direction);
            return true;
        }
        return false;
    }

    public void setName() {
        System.out.print("Choose a name: ");
        Scanner scanner = new Scanner(System. in);
        this.name = scanner. nextLine();
    }

    public String getName() {
        return name;
    }


}



