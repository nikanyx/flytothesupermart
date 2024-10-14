package org.codeforall.game;

public enum ObstacleType {
    TYPE1(200,400),
    TYPE2(400,600),
    TYPE3(600,800);

    private int height;
    private int yPos;
    ObstacleType(int height, int yPos) {
        this.height = height;
        this.yPos = yPos;
    }

    public int getHeight(){
        return height;
    }

    public int getyPos(){
        return yPos;
    }
}
