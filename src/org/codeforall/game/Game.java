package org.codeforall.game;

import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.w3c.dom.css.Rect;

public class Game {
    //starts game, background, obstacles
    private int delay = 200;
    private Rectangle rectangle;
    private Background gameBg;
    private Player player;
    private Rectangle obstacle;
    private Rectangle secondObstacle;
    private boolean gameOver;
    private int currentScore = 0;
    private static int highScore = 0;
    public static final int MAXX = 1580;
    public static final int MAXY = 1020;

    //private Keyboard

    public void init() {
        Canvas.setMaxX(MAXX);
        Canvas.setMaxY(MAXY);
        new Background();
        player = new Player();
        new MyKeyboardHandler(player);
        //initialize keyboard with player as argument
        //show highscore
        //if key press return
        try {
            start();
        }
        catch (Exception e) {
            System.out.println("Error");
        }
    }

    private void start() throws InterruptedException {
        gameBg = new Background();
        //generate obstacles
        obstacle = new Rectangle(1010,250,100,10);
        obstacle.setColor(Color.BLACK);
        obstacle.fill();
        secondObstacle = new Rectangle(1010,250,100,10);
        secondObstacle.setColor(Color.BLUE);
        secondObstacle.fill();
        //collisionDetector = new CollisionDetector(player);
        //collisionDetector.check(obstacle linked list)
        while (!gameOver) {
            // Pause for a while
            Thread.sleep(delay);
            moveObstacles();
            //if player collision
        }
        if (currentScore > highScore) {
            highScore = currentScore;
        }
    }

    private void moveObstacles(){

        obstacle.translate(-100,0);
        if (obstacle.getX() <= 500) {
            secondObstacle.translate(-100,0);
        }
        //obstacle array for visible objects, once they are not visible, they reset position and objecttype
        //collision checks for free space in vertical axis instead of object
        //move obstacle, if obstacle.getX() < player position, currentScore++;
        //if player collision, gameOver = true
    }

}
