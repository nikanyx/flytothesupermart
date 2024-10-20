package org.codeforall.game;


import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {
    //responsible for generating background
    //adds background elements
    //has background, background elements movement settings
    private int backgroundPos;
    private Picture background;

    public Background(int startPos){
        backgroundPos = startPos;
        background = new Picture(startPos,0, Game.IMGPREFIX + "background-city2.jpg");
        background.draw();
    }

    public void move(){
        background.translate(-1,0);
        backgroundPos--;
    }
}
