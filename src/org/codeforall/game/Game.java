package org.codeforall.game;

import org.academiadecodigo.simplegraphics.graphics.Canvas;

public class Game {
    //starts game, background, obstacles
    private int delay = 200;
    private Player player;
    private boolean gameOver = false;
    private int currentScore = 0;
    private static int highScore = 0;
    public static final int MAXX = 1580;
    public static final int MAXY = 1020;
    private Obstacle[] obstacles = new Obstacle[3];
    Background background = new Background();

    //private Keyboard

    public void init() {
        Canvas.setMaxX(MAXX);
        Canvas.setMaxY(MAXY);
        player = new Player();
        new MyKeyboardHandler(player);
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
        //initialize background music on the game level. too much?
        SoundHandler.playBackgroundMusic("resources/audio-game.wav");
        //generate obstacles
        for (int i = 0; i < obstacles.length; i++){
            obstacles[i] = ObjectFactory.getNewObstacle();
        }
        //initiate collision detector
        //collisionDetector = new CollisionDetector(player);
        //run game
        while (!gameOver) {
            // Pause for a while
            Thread.sleep(delay);
            background.move();
            moveObstacles();
            //check for collisions
            //collisionDetector.check(obstacle linked list)
            /* for (Object obstacle : obstacles){
                if (collisionDetector.check(obstacle.getObstaclePosition())){
                    gameOver = true;
                    break;
                }
            } */
        }
        //if player collision
        //Use Date for currentScore when start and when end: (int)((endDate.getTime() - startDate.getTime()) / 1000)
        if (currentScore > highScore) {
            highScore = currentScore;
        }
        //init();
    }

    private void moveObstacles(){
        if (obstacles[0].getPos() > -40) {
            obstacles[0].move(-100);
           // System.out.println(obstacles[0].getPos());
        }
        else {
            obstacles[0] = ObjectFactory.getNewObstacle();
        }
        if (obstacles[0].getPos() == 880 || (obstacles[1].getPos() < 1500 && obstacles[1].getPos() > -40)) {
            obstacles[1].move(-100);
        }
        else {
            obstacles[1] = ObjectFactory.getNewObstacle();
        }
        if (obstacles[1].getPos() == 880 || (obstacles[2].getPos() < 1500 && obstacles[2].getPos() > -40)) {
            obstacles[2].move(-100);
        }
        else {
            obstacles[2] = ObjectFactory.getNewObstacle();
        }

        //obstacle array for visible objects, once they are not visible, they reset position and objecttype
        //score? move obstacle, if obstacle.getX() < player position, currentScore++;
    }

}
