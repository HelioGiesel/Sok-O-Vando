package org.academiadecodigo.asynctomatics.sokovando.controlls;

import org.junit.Test;

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
    private void testShouldDoNothingWhenKeyPressed() {
        KeyboardListener keyboardListener = new KeyboardListener();

        keyboardListener.keyPressed(null);
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
    }

}


