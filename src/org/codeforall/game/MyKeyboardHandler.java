package org.codeforall.game;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class MyKeyboardHandler implements KeyboardHandler {

        private Keyboard keyboard;
        private Player player;

        public MyKeyboardHandler(Player player) {
            keyboard = new Keyboard(this);
            setKeyboardEvents();
            this.player = player;
        }

        private void setKeyboardEvents() {
            KeyboardEvent down = new KeyboardEvent();
            down.setKey(KeyboardEvent.KEY_DOWN);
            down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(down);

            KeyboardEvent up = new KeyboardEvent();
            up.setKey(KeyboardEvent.KEY_UP);
            up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(up);
        }

        @Override
        public void keyPressed(KeyboardEvent keyboardEvent) {
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
                player.moveDown();
            }

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
                player.moveUp();
            }

        }

        @Override
        public void keyReleased(KeyboardEvent keyboardEvent) {

        }
    }
