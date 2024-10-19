package org.codeforall.game;


import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {
    //responsible for generating background
    //adds background elements
    //has background, background elements movement settings
    int backgroundPos;
    Picture background;
    int backgroundWidth;



    public Background(int startPos){
        background = new Picture(startPos,0, Game.IMGPREFIX + "City1.jpg");

        backgroundWidth = background.getWidth();

        background.draw();

        backgroundPos = startPos;


    }

    public void move(){
        background.translate(-100,0);
        backgroundPos --;
        /*if (backgroundPos < -980) {
            new Background(1580);
        }*/
        if(backgroundPos < -980){//if background has moved comp off the canvas reset the position
            backgroundPos += backgroundWidth;//reset the position
            background.translate(backgroundWidth,0);//move it back to the rigth of the canvas
        }
    }

    public void loopBackground() throws InterruptedException {
        while(true) {
            move(); //Move the background
            Thread.sleep(20);//Adjust the delay to control speed
        }
    }






    }




