package org.codeforall.game;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {
    private Picture background1;
    private Picture background2;
    private int backgroundWidth;
    private final int moveSpeed = 5; // Speed of the background movement

    public Background(int startPos) {
        // Create two backgrounds side by side
        background1 = new Picture(startPos, 0, Game.IMGPREFIX + "City3.png");
        backgroundWidth = background1.getWidth();
        background2 = new Picture(startPos + backgroundWidth - 20, 0, Game.IMGPREFIX + "City3.png");
        background1.draw();
        background2.draw();
    }

    public void move() {
        // Move both backgrounds to the left
        background1.translate(-moveSpeed, 0);
        background2.translate(-moveSpeed, 0);

        // If background1 moves off the screen, reset its position to the right of background2
        if (background1.getX() + backgroundWidth <= 0) {
            background1.translate(backgroundWidth * 2 -20, 0);
        }

        // If background2 moves off the screen, reset its position to the right of background1
        if (background2.getX() + backgroundWidth <= 0) {
            background2.translate(backgroundWidth * 2 -20, 0);
        }
    }
}
