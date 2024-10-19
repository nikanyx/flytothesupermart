package org.codeforall.game;

public class CollisionDetector {
    private Player player;

    public CollisionDetector(Player player){
        this.player = player;
    }

    public boolean check(ObstaclePosition rect){
        if (player.getXPos() <= rect.getRightSide() &&
                player.getXPos() + player.getWidth() >= rect.getxPos() &&
                player.getYPos() + player.getHeight() >= rect.getYPos() &&
                player.getYPos() <= rect.getBottomSide()) {
            return true;
        }
        return false;
    }
}
