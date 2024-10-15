package org.codeforall.game;

public class CollisionDetector {
    private Player player;

    public CollisionDetector(Player player){
        this.player = player;
    }

    public boolean check(ObstaclePosition rect){
        /*if (player.x <= rect.getRightSide() && player.x+width >= rect.getXPos() && player.y+height >= rect.getYPos() && player.y <= rect.getHeight()){
            return true;
        }*/
        return false;
    }
}
