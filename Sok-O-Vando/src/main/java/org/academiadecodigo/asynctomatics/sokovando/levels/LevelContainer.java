package org.academiadecodigo.asynctomatics.sokovando.levels;

import org.academiadecodigo.asynctomatics.sokovando.elements.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class LevelContainer {
    private final HashMap<String, ArrayList<Position>> levelElementsMap = new HashMap<>();
    private final ArrayList<Position> wallList = new ArrayList<>();
    private final ArrayList<Position> boxList = new ArrayList<>();
    private final ArrayList<Position> spotList = new ArrayList<>();
    private Player player;
    public HashMap<String, ArrayList<Position>> getLevel(int levelNumber) {
        levelElementsMap.clear();
        wallList.clear();
        boxList.clear();
        spotList.clear();

        String levelString = "";

        if (levelNumber == 1) levelString = level1();
        if (levelNumber == 2) levelString = level2();
        if (levelNumber == 3) levelString = level3();
        if (levelNumber == 4) levelString = level4();
        if (levelNumber == 5) levelString = level5();

        levelParser(levelString);

        boxList.forEach(element -> ((Box) element).initBoxShape());

        levelElementsMap.put("walls", wallList);
        levelElementsMap.put("spots", spotList);
        levelElementsMap.put("boxes", boxList);

        return levelElementsMap;
    }

    public Player getPlayer() {
        if (player == null) player = new Player(Position.CELLSIZE, Position.CELLSIZE);
        return player;
    }

    private void levelParser(String levelString) {
        AtomicInteger columnReference = new AtomicInteger(0);
        AtomicInteger lineReference = new AtomicInteger(0);
        Arrays.stream(levelString.split("")).forEach((element) -> {
            int x = columnReference.getAndIncrement();
            int y = lineReference.get();

            // reset columns reference and increments line reference
            if (element.equals(",")) {
                columnReference.set(0);
                lineReference.incrementAndGet();
            }

            elementDecoder(element, x, y);
        });
    }

    private void elementDecoder(String element, int columnReference, int lineReference) {
        int x = columnReference * Position.CELLSIZE;
        int y = lineReference * Position.CELLSIZE;

        if (Objects.equals(element, "w")) wallList.add(new Wall(x,y));
        if (Objects.equals(element, "s")) spotList.add(new Spot(x,y));
        if (Objects.equals(element, "b")) boxList.add(new Box(x,y));
        if (Objects.equals(element, "p")) player = new Player(x,y);
    }

    private String level1() {
        return  "wwwwwwwwww,"+
                "w000w0000w,"+
                "w0wbw0wwbw,"+
                "w00pw0w00w,"+
                "www0w0w00w,"+
                "w000w0ww0w,"+
                "w0w000b00w,"+
                "w0w0www0sw,"+
                "w000000ssw,"+
                "wwwwwwwwww";
    }

    private String level2() {
       return   "wwwwwwwwwww,"+
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
    }

    private String level3() {
        return  "wwwwwwwwwww,"+
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
    }

    private String level4() {
        return  "wwwwwwwwwwwww,"+
                "wwwwwww000www,"+
                "wwwwwww000www,"+
                "wwww00s0w0www,"+
                "wwww0bs0b0b0w,"+
                "wwww0wsww0b0w,"+
                "wwww0wsswb00w,"+
                "ww00pwwsw00ww,"+
                "ww0b0b0sw0bww,"+
                "www0wwwsww0ww,"+
                "www00000000ww,"+
                "wwwwwww00wwww,"+
                "wwwwwwwwwwwww";
    }

    private String level5() {
        return  "wwwwwwwwwwwww,"+
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
    }
}
