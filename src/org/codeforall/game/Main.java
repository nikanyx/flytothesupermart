package org.codeforall.game;


import org.academiadecodigo.simplegraphics.graphics.Canvas;

public class Main {
    public static void main(String[] args) {

        //figure out how to start new games while program is running (i.e. player loses, game starts again keeping highest score)
        //perhaps start/restart screen? configure enter?
        //player and keyboard are initialized first
        Canvas.setMaxX(1000);
        Canvas.setMaxY(500);
        Game game = new Game();
        while (true) {
            game.init();
        }
        //game.start();
    }
}
