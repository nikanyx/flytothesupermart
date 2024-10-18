package org.codeforall.game;

import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Player {

    //create player with sprite
    //determine movement -> new class?
    //incorporate key press behaviour
    private int name;
    private int score;
    private Picture SuperMan;
    private int height;



    public Player() {

        SuperMan = new Picture(300, 250, "resources/supermansprite.png");
        SuperMan.draw();
        height = SuperMan.getHeight();
    }

    //Position of my Superman on the canvas
        public int getY() {
            if (SuperMan.getY() < 0) {
               return 0;
        }
        return SuperMan.getY();
    }

    //Can move down or up
        public void moveDown() {
            if (SuperMan.getY() + height < Game.MAXY) {
                SuperMan.translate(0, 10);  // Move sprite down if it's not at the bottom
            }
        }


        public void moveUp() {
            if (SuperMan.getY() > 0) {
                SuperMan.translate(0, -10);  // Move sprite up if it's not at the top
            }
        }


}




