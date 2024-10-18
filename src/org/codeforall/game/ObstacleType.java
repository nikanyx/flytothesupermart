package org.codeforall.game;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum ObstacleType {
    TYPE1(170,370,"Obstacle1-1.png","Obstacle1.png"),
    TYPE2(290,490,"Obstacle2-1.png","Obstacle2.png"),
    TYPE3(410,610,"Obstacle3-1.png","Obstacle3.png"),
    TYPE4(530,730,"Obstacle4-1.png","Obstacle4.png"),
    TYPE5(650,850,"Obstacle5-1.png","Obstacle5.png");

    private int height;
    private int yPos;
    private String topImg;
    private String botImg;
    private final String img = "resources/";

    ObstacleType(int height, int yPos, String topImg, String botImg) {
        this.height = height;
        this.yPos = yPos;
        this.topImg = topImg;
        this.botImg = botImg;
        /*this.topImg = new Picture(Game.MAXX+10,0,img+topImg);
        this.botImg = new Picture(Game.MAXX+10,yPos,img+botImg);
        this.topImg.draw();
        this.botImg.draw();*/
    }

    public int getHeight(){
        return height;
    }

    public int getyPos(){
        return yPos;
    }

    public String getTopImg(){
        return img+topImg;
    }

    public String getBotImg(){
        return img+botImg;
    }
}
