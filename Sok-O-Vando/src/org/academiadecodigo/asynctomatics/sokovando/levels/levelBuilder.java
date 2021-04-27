package org.academiadecodigo.asynctomatics.sokovando.levels;

import org.academiadecodigo.asynctomatics.sokovando.elements.Box;
import org.academiadecodigo.asynctomatics.sokovando.elements.Position;
import org.academiadecodigo.asynctomatics.sokovando.elements.Spot;
import org.academiadecodigo.asynctomatics.sokovando.elements.Wall;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class levelBuilder {

    public static List<Position> buildLevel(String levelString) {

        List<Position> levelCreated = Arrays.stream(levelString.split(";"))
                .map( s -> buildElementShape(s))
                .collect(Collectors.toList());

        return levelCreated;
    }

    public static Position buildElementShape(String elementInfo) {

        char shape = elementInfo.charAt(0);
        int x = Integer.parseInt(elementInfo.split(",")[1]);
        int y = Integer.parseInt(elementInfo.split(",")[2]);

        if (shape == 'W') return new Wall(x,y);
        if (shape == 's') return new Spot(x,y);
        if (shape == 'b') return new Box(x,y);

        return null;

    }

}
