package org.codeforall.game;

public class ObstaclePosition {
    private int xPos;
    private int yPos;
    private int height;

    public ObstaclePosition(int height, int yPos){
        xPos = Game.MAXX;
        this.height = height;
        this.yPos = yPos;
    }
}
