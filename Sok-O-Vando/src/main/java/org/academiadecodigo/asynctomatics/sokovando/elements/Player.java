
package org.academiadecodigo.asynctomatics.sokovando.elements;


import org.academiadecodigo.asynctomatics.sokovando.CollisionDetector;
import org.academiadecodigo.asynctomatics.sokovando.Directions;
import org.academiadecodigo.asynctomatics.sokovando.exceptions.WinningException;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player extends Position {

    Picture playerShape;
    Position[] level;


    public Player(int x, int y) {
        super(x, y);

        this.playerShape = new Picture(x, y, "resources/playerDownIcon.png");
        playerShape.draw();
    }

    public Picture getPlayerShape() {
        return playerShape;
    }

    @Override
    public void deleteShape() {
        this.playerShape.delete();
    }

    public String getPlayerIconDirection(Directions direction) {
        switch (direction) {
            case UP:
                return "resources/playerUpIcon.png";

            case LEFT:
                return "resources/playerLeftIcon.png";

            case RIGHT:
                return "resources/playerRightIcon.png";

            default:
                return "resources/playerDownIcon.png";
        }
    }


    public void checkMove(Directions direction, Position[] level) throws WinningException {

        this.level = level;

        Player ghostPosition = new Player(playerShape.getX(), playerShape.getY());

        boolean canMove = false;

        switch (direction) {
            case UP:
                ghostPosition.setY(getY() - CELLSIZE);
                canMove = !(CollisionDetector.isColliding(level, ghostPosition, direction));
                break;
            case DOWN:
                ghostPosition.setY(getY() + CELLSIZE);
                canMove = !(CollisionDetector.isColliding(level, ghostPosition, direction));
                break;
            case LEFT:
                ghostPosition.setX(getX() - CELLSIZE);
                canMove = !(CollisionDetector.isColliding(level, ghostPosition, direction));
                break;
            case RIGHT:
                ghostPosition.setX(getX() + CELLSIZE);
                canMove = !(CollisionDetector.isColliding(level, ghostPosition, direction));
                break;
        }

        ghostPosition.playerShape.delete();

        this.playerShape.load(getPlayerIconDirection(direction));

        playerShape.draw();


        if (canMove) this.move(direction);
    }

    public void move(Directions direction) {
        switch (direction) {
            case UP:
                this.setY(getY() - CELLSIZE);
                this.playerShape.translate(0, -CELLSIZE);
                break;
            case DOWN:
                this.setY(getY() + CELLSIZE);
                this.playerShape.translate(0, CELLSIZE);
                break;
            case LEFT:
                this.setX(getX() - CELLSIZE);
                this.playerShape.translate(-CELLSIZE, 0);
                break;
            case RIGHT:
                this.setX(getX() + CELLSIZE);
                this.playerShape.translate(CELLSIZE, 0);
                break;
        }
    }
}
