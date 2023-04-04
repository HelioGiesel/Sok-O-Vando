package org.academiadecodigo.asynctomatics.sokovando;

import org.academiadecodigo.asynctomatics.sokovando.controlls.Directions;
import org.academiadecodigo.asynctomatics.sokovando.elements.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CollisionDetector {
    Game game;
    HashMap<String, ArrayList<Position>> gameObjectsMap;
    Player player;

    public CollisionDetector(Game game, HashMap<String, ArrayList<Position>> gameObjectsMap, Player player) {
        this.game = game;
        this.gameObjectsMap = gameObjectsMap;
        this.player = player;
    }

    public CollisionDetectorResponse checkMovement(Directions direction) {
        CollisionDetectorResponse response = new CollisionDetectorResponse();

        Map<String, Position> next2ElementsByMove = getNext2Elements(direction);

        if (next2ElementsByMove.get("first") == null) {
            response.playerCanMove = true;
            return response;
        }

        if (next2ElementsByMove.get("first") instanceof Box && next2ElementsByMove.get("second") == null) {
            response.setBoxCanMoveScenario(next2ElementsByMove.get("first"));
            return response;
        }

        return response;
    }

    private Map<String, Position> getNext2Elements(Directions direction) {
        Map<String, Position> next2ElementsByMove = new HashMap<>();

        GenericPosition firstMovePosition = new GenericPosition(player.getX(), player.getY());
        Directions.setPositionNextCoordinatesByDirection(firstMovePosition, direction, 1);

        GenericPosition secondMovePosition = new GenericPosition(player.getX(), player.getY());
        Directions.setPositionNextCoordinatesByDirection(secondMovePosition, direction, 2);

        gameObjectsMap.get("walls").forEach(element -> {
            if (firstMovePosition.checkSamePosition(element)) next2ElementsByMove.put("first", element);
            if (secondMovePosition.checkSamePosition(element)) next2ElementsByMove.put("second", element);
        });

        gameObjectsMap.get("boxes").forEach(element -> {
            if (firstMovePosition.checkSamePosition(element)) next2ElementsByMove.put("first", element);
            if (secondMovePosition.checkSamePosition(element)) next2ElementsByMove.put("second", element);
        });

        return next2ElementsByMove;
    }
}


