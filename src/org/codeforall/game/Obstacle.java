package org.codeforall.game;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Obstacle {

    private ObstacleType obstacleType;
    private ObstaclePosition obstaclePosition;
    /*private Rectangle topRect;
    private Rectangle botRect;*/
    Picture topImg;
    Picture botImg;

    public Obstacle(ObstacleType obstacleType){
        this.obstacleType = obstacleType;
        obstaclePosition = new ObstaclePosition(obstacleType.getHeight(),obstacleType.getyPos(),70);
        /*topRect = new Rectangle(Game.MAXX+10,0,40, obstacleType.getHeight());
        botRect = new Rectangle(Game.MAXX+10,obstacleType.getyPos(),40,Game.MAXY-obstacleType.getyPos());//Game.MAXY-obstacleType.getyPos());
        topRect.setColor(Color.BLACK);
        botRect.setColor(Color.BLUE);
        topRect.fill();
        botRect.fill();*/
        this.topImg = new Picture(Game.MAXX+10,0,obstacleType.getTopImg());
        this.botImg = new Picture(Game.MAXX+10,obstacleType.getyPos(),obstacleType.getBotImg());
        this.topImg.draw();
        this.botImg.draw();
    }

    public void move(int x){
        topImg.translate(x,0);
        botImg.translate(x,0);
        obstaclePosition.setxPos(x);
    }

    public int getPos(){
        return obstaclePosition.getxPos();
    }

    public ObstaclePosition getObstaclePosition(){
        return obstaclePosition;
    }

}
