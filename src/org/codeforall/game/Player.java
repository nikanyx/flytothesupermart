package org.codeforall.game;

import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Player {

    //create player with sprite
    //determine movement -> new class?
    //incorporate key press behaviour
    private int name;
    private int score;
    private Picture SuperMan;
    public int playerPos = 480;


    public Player() {
        SuperMan = new Picture(300, 480, "/Users/codecadet/workspace/yellowgame/untitled-yellow-game/resources/supermansprite.png");
        SuperMan.draw();
    }
        public void moveDown() {
            SuperMan.translate(0, 20);
            playerPos += 20;
        }

        public void moveUp() {
            SuperMan.translate(0, -20);
            playerPos -= 20;
        }

    public int getPlayerPos() {
        return playerPos;
    }
}






