package org.academiadecodigo.asynctomatics.sokovando.controlls;

import org.junit.Test;

public class KeyboardListenerTest {

//    Mockito

    @Test
    private void testShouldDoNothingWhenKeyPressed() {
        KeyboardListener keyboardListener = new KeyboardListener();

        keyboardListener.keyPressed(null);
    }
}


