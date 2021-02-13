package org.academiadecodigo.asynctomatics.sokovando;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardListener implements KeyboardHandler {

    Game game;

    public void setup(Game game) {

        this.game = game;

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

        // Event of pressing the SPACE key
        KeyboardEvent startGamePressed = new KeyboardEvent();
        startGamePressed.setKey(KeyboardEvent.KEY_SPACE);
        startGamePressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(startGamePressed);

        // Event of releasing the SPACE key
        KeyboardEvent startGameReleased = new KeyboardEvent();
        startGameReleased.setKey(KeyboardEvent.KEY_SPACE);
        startGameReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(startGameReleased);

        // Event of pressing the 'R' key
        KeyboardEvent restartLevelPressed = new KeyboardEvent();
        restartLevelPressed.setKey(KeyboardEvent.KEY_R);
        restartLevelPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(restartLevelPressed);

        // Event of releasing the 'R' key
        KeyboardEvent restartLevelReleased = new KeyboardEvent();
        restartLevelReleased.setKey(KeyboardEvent.KEY_R);
        restartLevelReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(restartLevelReleased);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }

    
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == 38) {
            game.movePlayer(Directions.UP);
        }
        if (keyboardEvent.getKey() == 40) {
            game.movePlayer(Directions.DOWN);
        }
        if (keyboardEvent.getKey() == 37) {
            game.movePlayer(Directions.LEFT);
        }
        if (keyboardEvent.getKey() == 39) {
            game.movePlayer(Directions.RIGHT);
        }

        if (keyboardEvent.getKey() == 82) {
            game.restartLevel();
        }

        if (keyboardEvent.getKey() == 32) {
            System.exit(1);
        }
    }
}

