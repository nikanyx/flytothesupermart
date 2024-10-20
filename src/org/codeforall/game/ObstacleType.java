package org.codeforall.game;

public enum ObstacleType {
    TYPE1(10+150,10+300,"Obstacle1-1.png","Obstacle1.png"),
    TYPE2(10+217,10+367,"Obstacle2-1.png","Obstacle2.png"),
    TYPE3(10+285,10+435,"Obstacle3-1.png","Obstacle3.png"),
    TYPE4(10+353,10+503,"Obstacle4-1.png","Obstacle4.png"),
    TYPE5(10+420,10+570,"Obstacle5-1.png","Obstacle5.png");

    private int height;
    private int yPos;
    private String topImg;
    private String botImg;

    ObstacleType(int height, int yPos, String topImg, String botImg) {
        this.height = height;
        this.yPos = yPos;
        this.topImg = topImg;
        this.botImg = botImg;
    }

    public int getHeight(){
        return height;
    }

    public int getyPos(){
        return yPos;
    }

    public String getTopImg(){
        return Game.IMGPREFIX+topImg;
    }

    public String getBotImg(){
        return Game.IMGPREFIX+botImg;
    }
}
