package org.codeforall.game;

public class ObstaclePosition {
    private int xPos;
    private int yPos;
    private int width;
    private int height;

    public ObstaclePosition(int yPos, int height, int width){
        xPos = Game.MAXX;
        this.height = height;
        this.yPos = yPos;
        this.width = width;
    }

    public void setxPos(int x){
        xPos += x;
    }

    public int getxPos(){
        return xPos;
    }

    public int getYPos(){
        return yPos;
    }

    public int getRightSide(){
        return xPos + width;
    }

    public int getHeight(){
        return height;
    }
}
