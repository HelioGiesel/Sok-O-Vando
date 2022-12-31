package org.academiadecodigo.asynctomatics.sokovando;

import org.academiadecodigo.asynctomatics.sokovando.controlls.Directions;
import org.academiadecodigo.asynctomatics.sokovando.controlls.KeyboardListener;
import org.academiadecodigo.asynctomatics.sokovando.elements.*;
import org.academiadecodigo.asynctomatics.sokovando.exceptions.WinningException;
import org.academiadecodigo.asynctomatics.sokovando.levels.LevelContainer;
import org.academiadecodigo.bootcamp.Sound;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;
import java.util.Timer;

public class Game {
    private int currentLevelIndex = 1;
    private final int numberOfLevels = 5; // TODO: change dynamically when loading all levels
    private ArrayList<Position> currentLevel;
    private Player player;
    private Picture background;
    private Picture startMenu;
    private Picture level4Transition;
    private Picture levelClear;
    private Picture levelClear600;
    private boolean started = false;
    private final Sound menu = new Sound("/resources/startScreen.wav");
    private final Sound gameCoin = new Sound("/resources/gamecoin.wav");
    private final Sound main = new Sound("/resources/main.wav");
    private final Sound laugh = new Sound("/resources/evilLaugh.wav");
    private final Sound main2 = new Sound("/resources/level4_5.wav");

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
        currentLevel = new LevelContainer().getLevel(currentLevelIndex);
        player = (Player) currentLevel.stream().filter(element -> element instanceof Player).findFirst().orElse(null);
        if (player != null) player.drawPlayer();
    }

    public void movePlayer(Directions directions) {
        try {
            if (currentLevelIndex <= numberOfLevels) {
                switch (directions) {
                    case UP:
                        player.checkMove(Directions.UP, currentLevel);
                        break;

                    case DOWN:
                        player.checkMove(Directions.DOWN, currentLevel);
                        break;

                    case LEFT:
                        player.checkMove(Directions.LEFT, currentLevel);
                        break;

                    case RIGHT:
                        player.checkMove(Directions.RIGHT, currentLevel);
                        break;
                }
            }
        } catch (WinningException ex) {

            System.out.println("Won level " + currentLevelIndex);
            player.deleteShape();
            currentLevelIndex++;
            levelTransition();
        }
    }

    public void restartLevel() {
        for (Position element : currentLevel) element.deleteShape();
        player.deleteShape();
        init();
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public void initMenu() {

        menu.play(true);

        startMenu = new Picture(0, 0, "resources/startMenu.png");
        startMenu.draw();
    }


    public void afterInitMenu() {
        this.deleteStartMenu();
        menu.stop();
        gameCoin.play(true);
        levelTransition();
        main.play(true);
        this.setStarted(true);
    }

    public void deleteStartMenu() {
        startMenu.delete();
    }

    public void levelTransition() {
        switch (currentLevelIndex) {

            case 2:

            case 3:
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
                        },
                        3000
                );
                break;

            default:
                init();
                break;
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
                main.stop();
                main2.stop();
                laugh.play(true);
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
                                main2.play(true);
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
            player.getPlayerShape().delete();
            win.draw();
        }
    }
}