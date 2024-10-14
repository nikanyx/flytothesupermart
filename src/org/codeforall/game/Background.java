package org.codeforall.game;


import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {
    //responsible for generating background
    //adds background elements
    //has background, background elements movement settings

    Picture background;

    public Background(){
        background = new Picture(0,0, "resources/background-city.jpg");
        background.draw();
    }

    public void move(){
        background.translate(-1,0);
    }
}
