package org.codeforall.game;

public enum ObstacleType {
    TYPE1(250,350),
    TYPE2(150,250),
    TYPE3(350,450);

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
