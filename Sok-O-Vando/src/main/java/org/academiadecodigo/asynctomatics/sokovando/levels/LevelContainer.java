package org.academiadecodigo.asynctomatics.sokovando.levels;

import org.academiadecodigo.asynctomatics.sokovando.elements.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class LevelContainer {
    public ArrayList<Position> getLevel(int levelNumber) {
        switch (levelNumber) {
            case 1:
                return level1();
            case 2:
                return level2();
            case 3:
                return level3();
            case 4:
                return level4();
            case 5:
                return level5();
            default:
                return null;
        }
    }

    private ArrayList<Position> levelParser(String levelString) {
        AtomicInteger columnReference = new AtomicInteger(0);
        AtomicInteger lineReference = new AtomicInteger(0);
        return Arrays.stream(levelString.split("")).map((element) -> {
            int x = columnReference.getAndIncrement();
            int y = lineReference.get();

            // reset columns reference and increments line reference
            if (element.equals(",")) {
                columnReference.set(0);
                lineReference.incrementAndGet();
            }

            return elementDecoder(element, x, y);
        }).filter(Objects::nonNull).collect(Collectors.toCollection(ArrayList::new));
    }

    private Position elementDecoder(String element, int columnReference, int lineReference) {
        int x = columnReference * Position.CELLSIZE;
        int y = lineReference * Position.CELLSIZE;
        switch (element) {
            case "w":
                return new Wall(x,y);
            case "b":
                return new Box(x,y);
            case "s":
                return new Spot(x,y);
            case "p":
                return new Player(x,y);
            default:
                return null;
        }
    }

    private ArrayList<Position> level1() {
        String levelString =
                "wwwwwwwwww,"+
                "w000w0000w,"+
                "w0wbw0wwbw,"+
                "w00pw0w00w,"+
                "www0w0w00w,"+
                "w000w0ww0w,"+
                "w0w000b00w,"+
                "w0w0www0sw,"+
                "w000000ssw,"+
                "wwwwwwwwww";
        return levelParser(levelString);
    }

    private ArrayList<Position> level2() {
        String levelString =
                "wwwwwwwwwww,"+
                "ws0000000sw,"+
                "w000000000w,"+
                "w00w000w00w,"+
                "w00sbbbs00w,"+
                "w000bpb000w,"+
                "w00sbbbs00w,"+
                "w00w000w00w,"+
                "w000000000w,"+
                "ws0000000sw,"+
                "wwwwwwwwwww";
        return levelParser(levelString);
    }

    private ArrayList<Position> level3() {
        String levelString =
                "wwwwwwwwwww,"+
                "w00000p000w,"+
                "w000bbww00w,"+
                "w000w0b000w,"+
                "ww0000000ww,"+
                "wwws00b0www,"+
                "wwww000wwww,"+
                "wwww000wwww,"+
                "wwwws00wwww,"+
                "wwwwss0wwww,"+
                "wwwwwwwwwww";
        return levelParser(levelString);
    }

    private ArrayList<Position> level4() {
        String levelString =
                "wwwwwwwwwwwww,"+
                "wwwwwww000www,"+
                "wwwwwww000www,"+
                "wwww00s0w0www,"+
                "wwww0bs0b0b0w,"+
                "wwww0wsww0b0w,"+
                "wwww0wsswb00w,"+
                "ww000wwsw00ww,"+
                "ww0b0b0sw0bww,"+
                "www0wwwsww0ww,"+
                "www00000000ww,"+
                "wwwwwww00wwww,"+
                "wwwwwwwwwwwww";
        return levelParser(levelString);
    }

    private ArrayList<Position> level5() {
        String levelString =
                "wwwwwwwwwwwww,"+
                "w00000000000w,"+
                "w0sbsbsbsbs0w,"+
                "w0bsbsbsbsb0w,"+
                "w0sbsbsbsbs0w,"+
                "w0bsbsbsbsb0w,"+
                "w0sbsbpbsbs0w,"+
                "w0bsbsbsbsb0w,"+
                "w0sbsbsbsbs0w,"+
                "w0bsbsbsbsb0w,"+
                "w0sbsbsbsbs0w,"+
                "w00000000000w,"+
                "wwwwwwwwwwwww";
        return levelParser(levelString);
    }
}
