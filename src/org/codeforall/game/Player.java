package org.codeforall.game;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {
    //create player with sprite
    //determine movement -> new class?
    //incorporate key press behaviour
    private int name;
    private int score;
    private int height;
    private Picture superMan;
    private int xPos = 300;
    private int yPos = 480;

    public Player() {
        superMan = new Picture(xPos, yPos, Game.IMGPREFIX + "supermansprite2.png");
        superMan.draw();
        height = superMan.getHeight();
    }

    //Can move down or up
    public void moveDown() {
    // Move sprite down if it's not at the bottom
        if (superMan.getY() + height < Game.MAXY) {
            superMan.translate(0, 20);
            yPos += 20;
        }
    }

    public void moveUp() {
    // Move sprite up if it's not at the top
        if (superMan.getY() > 0) {
            superMan.translate(0, -20);
            yPos -= 20;
        }
    }

    public int getYPos() {
        return yPos;
    }
    public int getXPos(){
        return xPos;
    }
    public int getHeight(){
        return height;
    }
    public int getWidth(){
        return superMan.getWidth();
    }
}

