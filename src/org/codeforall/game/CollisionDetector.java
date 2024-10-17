package org.codeforall.game;

public class CollisionDetector {
    private Player player;

    public CollisionDetector(Player player){
        this.player = player;
    }

    public boolean check(ObstaclePosition rect){
        if (player.getPlayerPos() <= rect.getRightSide() &&
                player.getPlayerPos()+ 50 >= rect.getxPos() &&
                player.getPlayerPos() + 20 >= rect.getYPos() &&
                player.getPlayerPos() <= rect.getHeight()) {
            return true;
        }
        return false;

    }

}
