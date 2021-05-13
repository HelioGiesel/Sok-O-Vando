package org.academiadecodigo.asynctomatics.sokovando.controlls;

import org.academiadecodigo.asynctomatics.sokovando.Game;
import org.academiadecodigo.asynctomatics.sokovando.TerminationSwitch;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class KeyboardListenerTest {

    private KeyboardListener keyboardListener;
    private TerminationSwitch terminationSwitch;

    @Before
    public void setup() {
        this.keyboardListener = new KeyboardListener();
        keyboardListener.setup();

        terminationSwitch = mock(TerminationSwitch.class);
        keyboardListener.setTerminationSwitch(terminationSwitch);
    }

    @Test
    public void testShouldExitIfKeyQIsReleased() {
        // given
        KeyboardEvent keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboardEvent.setKey(KeyboardEvent.KEY_Q);

        Game game = mock(Game.class);
        keyboardListener.setGame(game);
        when(game.isStarted()).thenReturn(true);

        // when
        keyboardListener.keyReleased(keyboardEvent);

        // then
        verify(terminationSwitch).terminateGame();
    }

    @Test
    public void testShouldMovePlayerUpWhenUpArrowIsReleased() {
        // given
        KeyboardEvent keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboardEvent.setKey(KeyboardEvent.KEY_UP);

        Game game = mock(Game.class);
        keyboardListener.setGame(game);
        when(game.isStarted()).thenReturn(true);

        // when
        keyboardListener.keyReleased(keyboardEvent);

        // then
        verify(game).movePlayer(Directions.UP);
        verifyZeroInteractions(terminationSwitch);
        verify(game, never()).movePlayer(Directions.DOWN);
        verify(game, never()).movePlayer(Directions.LEFT);
        verify(game, never()).movePlayer(Directions.RIGHT);
        verify(game, never()).restartLevel();
    }

    @Test
    public void testShouldMovePlayerDownWhenDownArrowIsReleased() {
        // given
        KeyboardEvent keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboardEvent.setKey(KeyboardEvent.KEY_DOWN);

        Game game = mock(Game.class);
        keyboardListener.setGame(game);
        when(game.isStarted()).thenReturn(true);

        // when
        keyboardListener.keyReleased(keyboardEvent);

        // then
        verify(game).movePlayer(Directions.DOWN);
        verify(game, never()).movePlayer(Directions.UP);
        verify(game, never()).movePlayer(Directions.LEFT);
        verify(game, never()).movePlayer(Directions.RIGHT);
        verify(game, never()).restartLevel();
    }

    @Test
    public void testShouldMovePlayerLeftWhenLeftArrowIsReleased() {
        // given
        KeyboardEvent keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboardEvent.setKey(KeyboardEvent.KEY_LEFT);

        Game game = mock(Game.class);
        keyboardListener.setGame(game);
        when(game.isStarted()).thenReturn(true);

        // when
        keyboardListener.keyReleased(keyboardEvent);

        // then
        verify(game).movePlayer(Directions.LEFT);
        verify(game, never()).movePlayer(Directions.DOWN);
        verify(game, never()).movePlayer(Directions.UP);
        verify(game, never()).movePlayer(Directions.RIGHT);
        verify(game, never()).restartLevel();
    }

    @Test
    public void testShouldMovePlayerRightWhenRightArrowIsReleased() {
        // given
        KeyboardEvent keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboardEvent.setKey(KeyboardEvent.KEY_RIGHT);

        Game game = mock(Game.class);
        keyboardListener.setGame(game);
        when(game.isStarted()).thenReturn(true);

        // when
        keyboardListener.keyReleased(keyboardEvent);

        // then
        verify(game).movePlayer(Directions.RIGHT);
        verify(game, never()).movePlayer(Directions.DOWN);
        verify(game, never()).movePlayer(Directions.LEFT);
        verify(game, never()).movePlayer(Directions.UP);
        verify(game, never()).restartLevel();
    }

    @Test
    public void testShouldRestartGameWhenRButtonIsReleased() {
        // given
        KeyboardEvent keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboardEvent.setKey(KeyboardEvent.KEY_R);

        Game game = mock(Game.class);
        keyboardListener.setGame(game);
        when(game.isStarted()).thenReturn(true);

        // when
        keyboardListener.keyReleased(keyboardEvent);

        // then
        verify(game).restartLevel();
        verify(game, never()).movePlayer(Directions.DOWN);
        verify(game, never()).movePlayer(Directions.LEFT);
        verify(game, never()).movePlayer(Directions.RIGHT);
        verify(game, never()).movePlayer(Directions.UP);
    }

    @Test
    public void testShouldStartWhenSpaceIsReleased() {
        // given
        KeyboardEvent keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboardEvent.setKey(KeyboardEvent.KEY_SPACE);

        Game game = mock(Game.class);
        keyboardListener.setGame(game);
        when(game.isStarted()).thenReturn(false);

        // when
        keyboardListener.keyReleased(keyboardEvent);

        // then
        verify(game).setStarted(true);
        verify(game, never()).movePlayer(Directions.DOWN);
        verify(game, never()).movePlayer(Directions.LEFT);
        verify(game, never()).movePlayer(Directions.RIGHT);
        verify(game, never()).movePlayer(Directions.UP);
        verify(game, never()).restartLevel();
    }

}


