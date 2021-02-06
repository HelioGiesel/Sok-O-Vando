package org.academiadecodigo.asynctomatics.sokovando;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Main {
    public static void main(String[] args) {
        Rectangle test = new Rectangle(20,20,150,150);
        test.setColor(Color.RED);
        test.fill();
    }
}
