package org.codeforall.game;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Obstacle {

    private ObstacleType obstacleType;
    private ObstaclePosition topObsPosition;
    private ObstaclePosition botObsPosition;
    private Picture topImg;
    private Picture botImg;

    public Obstacle(ObstacleType obstacleType){
        this.obstacleType = obstacleType;
        this.topImg = new Picture(Game.MAXX,0,obstacleType.getTopImg());
        this.botImg = new Picture(Game.MAXX,obstacleType.getyPos(),obstacleType.getBotImg());
        this.topImg.draw();
        this.botImg.draw();
        topObsPosition = new ObstaclePosition(0,obstacleType.getHeight(),70);
        botObsPosition = new ObstaclePosition(obstacleType.getyPos(), botImg.getHeight(), 70);
    }

    public void move(int x){
        topImg.translate(x,0);
        botImg.translate(x,0);
        topObsPosition.setxPos(x);
        botObsPosition.setxPos(x);
    }

    public int getTopPos(){
        return topObsPosition.getxPos();
    }

    public int getBotPos(){
        return botObsPosition.getxPos();
    }

    public ObstaclePosition getTopObsPosition(){
        return topObsPosition;
    }

    public ObstaclePosition getBotObsPosition(){
        return botObsPosition;
    }

    public void resetObstacle(){
        obstacleType = ObstacleType.values()[(int) (Math.random() * ObstacleType.values().length)];
        topImg.delete();
        topImg = new Picture(Game.MAXX,0,obstacleType.getTopImg());
        topImg.draw();
        topObsPosition.resetPos(0,obstacleType.getHeight());
        botImg.delete();
        botImg = new Picture(Game.MAXX,obstacleType.getyPos(),obstacleType.getBotImg());
        botImg.draw();
        botObsPosition.resetPos(obstacleType.getyPos(), botImg.getHeight());
    }
}
