package org.codeforall.game;

import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Player {

    //create player with sprite
    //determine movement -> new class?
    //incorporate key press behaviour
    private int name;
    private int score;
    private int height;
    private Picture SuperMan;
    public int playerPos = 480;

    public Player() {
        SuperMan = new Picture(300, 480, "/Users/codecadet/workspace/yellowgame/untitled-yellow-game/resources/supermansprite2.png");
        SuperMan.draw();
        height = SuperMan.getHeight();
    }

    //Can move down or up
    public void moveDown() {
    // Move sprite down if it's not at the bottom
        if (SuperMan.getY() + height < Game.MAXY) {
            SuperMan.translate(0, 20);
            playerPos += 20;
        }
    }

    public void moveUp() {
    // Move sprite up if it's not at the top
        if (SuperMan.getY() > 0) {
            SuperMan.translate(0, -20);
            playerPos -= 20;
        }
    }

    public int getPlayerPos() {
        return playerPos;
    }
}

