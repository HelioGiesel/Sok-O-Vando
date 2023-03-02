
package org.academiadecodigo.asynctomatics.sokovando.elements;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Box extends Position {

    Picture boxShape;
    String imageResourcePath = "resources/jsIcon.png";

    public Box(int x, int y) {
        super(x, y);
    }

    public void initBoxShape() {
        this.boxShape = super.initShape(imageResourcePath);
    }
}
