package org.academiadecodigo.asynctomatics.sokovando;

import java.util.Scanner;

public class Player {

    private String name;

    public boolean checkEdges() {
        return true;
    }

    public void move() {}

    public boolean isSpot() {
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        
        System.out.print("Choose a name: ");
        Scanner scanner = new Scanner(System. in);
        this.name = scanner. nextLine();
    }

}
