package org.academiadecodigo.asynctomatics.sokovando;

import org.academiadecodigo.asynctomatics.sokovando.controlls.Directions;
import org.academiadecodigo.asynctomatics.sokovando.controlls.KeyboardListener;
import org.academiadecodigo.asynctomatics.sokovando.elements.*;
import org.academiadecodigo.asynctomatics.sokovando.levels.LevelContainer;
import org.academiadecodigo.bootcamp.Sound;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;

public class Game {
    private int currentLevelIndex = 1;
    private final int numberOfLevels = 5; // TODO: change dynamically when loading all levels
    private HashMap<String, ArrayList<Position>> currentLevel;
    private Player player;
    private Picture background;
    private Picture startMenu;
    private Picture level4Transition;
    private Picture levelClear;
    private Picture levelClear600;
    private boolean started = false;
    private CollisionDetector collisionDetector;
    private final Sound menuMusic = new Sound("/resources/startScreen.wav");
    private final Sound gameCoinSound = new Sound("/resources/gamecoin.wav");
    private final Sound mainMusic = new Sound("/resources/main.wav");
    private final Sound laughSound = new Sound("/resources/evilLaugh.wav");
    private final Sound main2Music = new Sound("/resources/level4_5.wav");

    public Game() {
        KeyboardListener keyboard = new KeyboardListener();
        keyboard.setTerminationSwitch(new TerminationSwitch());
        keyboard.setGame(this);
        keyboard.setup();
    }

    public boolean isStarted() {
        return started;
    }

    private void loadLevel() {
        LevelContainer levelContainer = new LevelContainer();
        currentLevel = levelContainer.getLevel(currentLevelIndex);
        player = levelContainer.getPlayer();
        player.drawPlayer();
        collisionDetector = new CollisionDetector(this, currentLevel, player);
    }

    public void movePlayer(Directions direction) {
        if (currentLevelIndex > numberOfLevels) return;

        CollisionDetectorResponse collisionResponse = collisionDetector.checkMovement(direction);

        player.setPlayerIconDirection(direction);

        if (collisionResponse.playerCanMove) {
            Directions.setPositionNextCoordinatesByDirection(player, direction, 1);
            Directions.translatePositionShape(player, direction);
        }

        if (collisionResponse.nextObstacleCanMove && collisionResponse.nextObstacle != null) {
            Directions.setPositionNextCoordinatesByDirection(collisionResponse.nextObstacle, direction, 1);
            Directions.translatePositionShape(collisionResponse.nextObstacle, direction);
        }

        checkBoxesOnSpots();
    }

    private void checkBoxesOnSpots() {
        int numberOfBoxOnSpot = 0;

        for (Position box : currentLevel.get("boxes")) {
            for (Position spot : currentLevel.get("spots")) {
                if (box.checkSamePosition(spot)) numberOfBoxOnSpot++;
            }
        }
        if (numberOfBoxOnSpot == currentLevel.get("spots").size()) levelWon();
    }

    private void levelWon() {
        System.out.println("Won level " + currentLevelIndex);
        player.deleteShape();
        currentLevelIndex++;
        levelTransition();
    }

    public void restartLevel() {
        currentLevel.forEach((key, value) -> value.forEach(Position::deleteShape));
        player.deleteShape();
        init();
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public void initMenu() {
        menuMusic.play(true);

        startMenu = new Picture(0, 0, "resources/startMenu.png");
        startMenu.draw();
    }


    public void afterInitMenu() {
        startMenu.delete();
        menuMusic.stop();
        gameCoinSound.play(true);
        levelTransition();
        mainMusic.play(true);
        this.setStarted(true);
    }

    public void levelTransition() {
        if (currentLevelIndex == 2 || currentLevelIndex == 3) {
            player = null;
            levelClear = new Picture(0, 0, "resources/levelClear550.png");
            levelClear.draw();
            setStarted(false);
            Timer t1 = new java.util.Timer();
            t1.schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            levelClear.delete();
                            init();
                            t1.cancel();
                            setStarted(true);
                        }
                    },3000
            );
        } else {
            init();
        }
    }

    public void init() {
        switch (currentLevelIndex) {
            case 1:
            case 2:
            case 3:
                background = new Picture(0, 0, "resources/background500.png");
                background.draw();
                loadLevel();
                break;

            case 4:
                player = null;
                mainMusic.stop();
                main2Music.stop();
                laughSound.play(true);
                //Keep transition when level is restarted
                level4Transition = new Picture(0, 0, "resources/level4Transition.png");
                level4Transition.draw();
                setStarted(false);
                Timer t3 = new java.util.Timer();
                t3.schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                level4Transition.delete();
                                main2Music.play(true);
                                background = new Picture(0, 0, "resources/background600.png");
                                background.draw();
                                loadLevel();
                                t3.cancel();
                                setStarted(true);
                            }
                        },
                        5000
                );
                break;

            case 5:
                player = null;
                levelClear600 = new Picture(0, 0, "resources/levelClear600.png");
                levelClear600.draw();
                setStarted(false);
                Timer t4 = new java.util.Timer();
                t4.schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                levelClear600.delete();
                                background = new Picture(0, 0, "resources/background600.png");
                                background.draw();
                                loadLevel();
                                t4.cancel();
                                setStarted(true);
                            }
                        },
                        3000
                );
                break;
        }

        if (currentLevelIndex > numberOfLevels) {
            System.out.println("You are a beast!! You deserve a clap from Leandro and one 'Até já' from you know who");
            Picture win = new Picture(0, 0, "/resources/youwin.png");
            player.getShape().delete();
            win.draw();
        }
    }
}