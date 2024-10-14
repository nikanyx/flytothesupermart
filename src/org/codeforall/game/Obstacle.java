package org.codeforall.game;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Obstacle {

    private ObstacleType obstacleType;
    private ObstaclePosition obstaclePosition;
    private Rectangle topRect;
    private Rectangle botRect;

    public Obstacle(ObstacleType obstacleType){
        this.obstacleType = obstacleType;
        obstaclePosition = new ObstaclePosition(obstacleType.getHeight(),obstacleType.getyPos());
    }

    public void genRectangle(){
        topRect = new Rectangle(1010,0,10,obstacleType.getHeight());
        botRect = new Rectangle(1010,obstacleType.getyPos(),10,500);
        topRect.setColor(Color.BLACK);
        botRect.setColor(Color.BLACK);
        topRect.fill();
        botRect.fill();
    }

}
