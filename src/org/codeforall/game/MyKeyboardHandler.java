package org.codeforall.game;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class MyKeyboardHandler implements KeyboardHandler {

    private Keyboard keyboard;
    private Player player;
    private Game game;

    public MyKeyboardHandler(Player player, Game game) {
        keyboard = new Keyboard(this);
        setKeyboardEvents();
        this.player = player;
        this.game = game;
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

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(space);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
            player.moveDown();
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
            player.moveUp();
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            if (game.getWaitingForStart() > 0) {
                game.setWaitingForStart(0);
            }
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}

