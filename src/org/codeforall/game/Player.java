package org.codeforall.game;

import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Player {

    //create player with sprite
    //determine movement -> new class?
    //incorporate key press behaviour
    private int name;
    private int score;
    private Picture SuperMan;

    public Player() {
        SuperMan = new Picture(0, 250, "resources/supermansprite.png");
        SuperMan.draw();

    }
        public void moveDown() {
            SuperMan.translate(0, 10);
        }

        public void moveUp() {
            SuperMan.translate(0, -10);
        }

    }




