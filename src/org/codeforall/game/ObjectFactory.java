package org.codeforall.game;

public class ObjectFactory {

    public static Obstacle getNewObstacle() {

        int random = (int) (Math.random() * ObstacleType.values().length);
        ObstacleType obstacleType = ObstacleType.values()[random];

        Obstacle obstacle = new Obstacle (obstacleType);

        return obstacle;
    }
}
