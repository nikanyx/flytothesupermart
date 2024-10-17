package org.codeforall.game;


import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {
    //responsible for generating background
    //adds background elements
    //has background, background elements movement settings
    int backgroundPos;
    Picture background;

    public Background(int startPos){
        background = new Picture(startPos,0, "/Users/codecadet/workspace/yellowgame/untitled-yellow-game/resources/background-city.jpg");
        background.draw();

    }

    public void move(){
        background.translate(-1,0);
        backgroundPos --;
        System.out.println(backgroundPos);
        /*if (backgroundPos < -980) {
            new Background(1580);
        }*/
    }

}
