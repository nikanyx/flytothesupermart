package org.codeforall.game;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import sun.awt.OSInfo;

public enum ObstacleType {
    TYPE1(250,350),
    TYPE2(150,250),
    TYPE3(350,450);

    ObstacleType(int height, int yPos) {
        Rectangle topRect = new Rectangle(1010,0,10,height);
        Rectangle botRect = new Rectangle(1010,yPos,10,500);
        topRect.setColor(Color.BLACK);
        botRect.setColor(Color.BLACK);
        topRect.fill();
        botRect.fill();
    }
}
