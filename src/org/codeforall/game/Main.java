package org.codeforall.game;

public class Main {
    public static void main(String[] args) {

        //figure out how to start new games while program is running (i.e. player loses, game starts again keeping highest score)
        //perhaps start/restart screen? configure enter?
        //player and keyboard are initialized first
        Game game = new Game();
        game.start();
    }
}
