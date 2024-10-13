package org.codeforall.game;

import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Main {
    public static void main(String[] args) {

        //figure out how to start new games while program is running (i.e. player loses, game starts again keeping highest score)
        //perhaps start/restart screen? configure enter?
        //player and keyboard are initialized first
        Game game = new Game();
        //game.start();
        Canvas.setMaxX(1580);
        Canvas.setMaxY(1020);


        Picture backGround = new Picture(0,0, "resources/background-city.jpg");
        backGround.draw();


        Player superMan = new Player();
        new MyKeyboardHandler(superMan);




    }
}
