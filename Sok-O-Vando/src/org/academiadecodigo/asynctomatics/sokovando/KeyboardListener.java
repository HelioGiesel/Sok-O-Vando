package org.academiadecodigo.asynctomatics.sokovando;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class KeyboardListener implements KeyboardHandler {

    Player player;
    Position[] level;

    public void setup(Player player, Position[] level1) {

        this.player = player;
        this.level = level1;

        Keyboard keyboard = new Keyboard(this);

        // Event of pressing the UP arrow
        KeyboardEvent upArrowPressed = new KeyboardEvent();
        upArrowPressed.setKey(KeyboardEvent.KEY_UP);
        upArrowPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(upArrowPressed);

        // Event of releasing the UP arrow
        KeyboardEvent upArrowReleased = new KeyboardEvent();
        upArrowReleased.setKey(KeyboardEvent.KEY_UP);
        upArrowReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(upArrowReleased);

        // Event of pressing the DOWN arrow
        KeyboardEvent downArrowPressed = new KeyboardEvent();
        downArrowPressed.setKey(KeyboardEvent.KEY_DOWN);
        downArrowPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(downArrowPressed);

        // Event of releasing the DOWN arrow
        KeyboardEvent downArrowReleased = new KeyboardEvent();
        downArrowReleased.setKey(KeyboardEvent.KEY_DOWN);
        downArrowReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(downArrowReleased);

        // Event of pressing the LEFT arrow
        KeyboardEvent leftArrowPressed = new KeyboardEvent();
        leftArrowPressed.setKey(KeyboardEvent.KEY_LEFT);
        leftArrowPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(leftArrowPressed);

        // Event of releasing the LEFT arrow
        KeyboardEvent leftArrowReleased = new KeyboardEvent();
        leftArrowReleased.setKey(KeyboardEvent.KEY_LEFT);
        leftArrowReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(leftArrowReleased);

        // Event of pressing the RIGHT arrow
        KeyboardEvent rightArrowPressed = new KeyboardEvent();
        rightArrowPressed.setKey(KeyboardEvent.KEY_RIGHT);
        rightArrowPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(rightArrowPressed);

        // Event of releasing the RIGHT arrow
        KeyboardEvent rightArrowReleased = new KeyboardEvent();
        rightArrowReleased.setKey(KeyboardEvent.KEY_RIGHT);
        rightArrowReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(rightArrowReleased);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == 38) {  }
        if (keyboardEvent.getKey() == 40) {   }
        if (keyboardEvent.getKey() == 37) {   }
        if (keyboardEvent.getKey() == 39) {   }
    }

    
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == 38) {
            player.checkMove(Directions.UP, level);
            player.playerShape.delete();
            player.playerShape = player.getPlayerUpIcon(player.getX(), player.getY());
            player.playerShape.draw();
        }
        if (keyboardEvent.getKey() == 40) {
            player.checkMove(Directions.DOWN, level);
            player.playerShape.delete();
            player.playerShape = player.getPlayerDownIcon(player.getX(), player.getY());
            player.playerShape.draw();
        }
        if (keyboardEvent.getKey() == 37) {
            player.checkMove(Directions.LEFT, level);
            player.playerShape.delete();
            player.playerShape = player.getPlayerLeftIcon(player.getX(), player.getY());
            player.playerShape.draw();
        }
        if (keyboardEvent.getKey() == 39) {
            player.checkMove(Directions.RIGHT, level);
            player.playerShape.delete();
            player.playerShape = player.getPlayerRightIcon(player.getX(), player.getY());
            player.playerShape.draw();
        }
    }

}



