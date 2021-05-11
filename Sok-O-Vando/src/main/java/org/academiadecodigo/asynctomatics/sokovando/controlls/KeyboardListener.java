package org.academiadecodigo.asynctomatics.sokovando.controlls;

import org.academiadecodigo.asynctomatics.sokovando.Game;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardListener implements KeyboardHandler {

    private Game game;

    public void setGame(Game game) {
        this.game = game;
    }

    public void setup() {

        Keyboard keyboard = new Keyboard(this);

        int[] keyNumber = {
                KeyboardEvent.KEY_UP,
                KeyboardEvent.KEY_DOWN,
                KeyboardEvent.KEY_LEFT,
                KeyboardEvent.KEY_RIGHT,
                KeyboardEvent.KEY_SPACE,
                KeyboardEvent.KEY_R,
                KeyboardEvent.KEY_Q
        };

        KeyboardEvent[] keys = new KeyboardEvent[keyNumber.length];

        for (int i = 0; i < keys.length; i++) {
            keys[i] = new KeyboardEvent();
            keys[i].setKey(keyNumber[i]);
            keys[i].setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
            keyboard.addEventListener(keys[i]);
        }
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_Q) {
            System.exit(1);
        }

        if (game.started) {

            switch (keyboardEvent.getKey()) {
                case KeyboardEvent.KEY_UP:
                    game.movePlayer(Directions.UP);
                    break;

                case KeyboardEvent.KEY_DOWN:
                    game.movePlayer(Directions.DOWN);
                    break;

                case KeyboardEvent.KEY_LEFT:
                    game.movePlayer(Directions.LEFT);
                    break;

                case KeyboardEvent.KEY_RIGHT:
                    game.movePlayer(Directions.RIGHT);
                    break;

                case KeyboardEvent.KEY_R:
                    game.restartLevel();
                    break;
            }

        } else {

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) game.setStarted(true);

        }
    }
}

