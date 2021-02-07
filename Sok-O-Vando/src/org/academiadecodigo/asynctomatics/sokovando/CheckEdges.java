package org.academiadecodigo.asynctomatics.sokovando;

public class CheckEdges {
    public static boolean box(Box movingBox){
        for (Box boxElement : boxesContainer) {
            if (boxElement != movingBox) {
                if ((movingBox.x == boxElement.x) && (movingBox.y == boxElement.y)) {
                    return true;
                }
            }
            return false;
        }
    }
    public static boolean wall(Position element){

        int elementEndPointX = element.width + element.x;
        int elementEndPointY = element.height + element.y;

        for (Wall wall : wallContainer) {

            int wallEndPointX = wall.x + wall.width;
            int wallEndPointY = wall.y + wall.height;

            if ((
                ((wall.x <= element.x) && (wallEndPointX >= element.x)) &&
                ((wall.y <= element.y) && (wallEndPointY >= element.y))
                ) || (
                ((wall.x <= elementEndPointX) && (wallEndPointX >= elementEndPointX)) &&
                ((wall.y <= elementEndPointY) && (wallEndPointY >= elementEndPointY))
                )){
                return true;
            }
        }
        return false;
    }

    public static boolean spot(Box box){

        for (Spot spot : spotContainer){
            if ((spot.x == box.x) && (spot.y == box.y)){
                return true;
            }
        }
        return false;
    }
}
