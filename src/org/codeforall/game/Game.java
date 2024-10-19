package org.codeforall.game;

import org.academiadecodigo.simplegraphics.graphics.Canvas;

public class Game {
    //starts game, background, obstacles
    private int delay = 25;
    private Player player;
    private boolean gameOver = false;
    private boolean waitingForStart = true;
    private int currentScore = 0;
    private static int highScore = 0;
    public static final int MAXX = 1580;
    public static final int MAXY = 1020;
    public static final String IMGPREFIX = "resources/";
    private Obstacle[] obstacles = new Obstacle[3];
    private Background background = new Background(0);





    //no fim retirar a image
    //private Picture menu = new Picture(550,375,IMGPREFIX + "Menu-Image.png");
    private Menu menu = new Menu(player);

    public void init() {
        Canvas.setMaxX(MAXX);
        Canvas.setMaxY(MAXY);
        player = new Player();
        new MyKeyboardHandler(player,this);
        //show highscore
        //if key press return
        start();
    }

    public void start() {
        //initialize background music on menu
       // SoundHandler.playBackgroundMusic(IMGPREFIX + "audio-menu.wav");


        //generate obstacles
        for (int i = 0; i < obstacles.length; i++){
            obstacles[i] = ObjectFactory.getNewObstacle();
        }

        //initiate collision detector
        CollisionDetector collisionDetector = new CollisionDetector(player);

        //run game
        while (!gameOver) {
                try {
                    // Pause for a while
                    Thread.sleep(delay);
                    if (waitingForStart){
                        //menu vai aparecer
                        menu.showMenu();

                    }
                    else {
                       // menu desaparece
                        menu.hide();
                        //SoundHandler.playBackgroundMusic(IMGPREFIX + "audio-game.wav");
                        background.loopBackground();

                        moveObstacles();

                        //check for collisions
                        for (Obstacle obs : obstacles) {
                            if (collisionDetector.check(obs.getTopObsPosition()) || collisionDetector.check(obs.getBotObsPosition())) {
                                gameOver = true;

                                menu.showLose();
                                //
                                break;
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }


        //if player collision
        //Use Date for currentScore when start and when end: (int)((endDate.getTime() - startDate.getTime()) / 1000)
        if (currentScore > highScore) {
            highScore = currentScore;
        }

        //init();
    }

    private void moveObstacles(){
        if (obstacles[0].getTopPos() > -70) {
            obstacles[0].move(-12);
        }
        else {
            obstacles[0] = ObjectFactory.getNewObstacle();
        }
        if (obstacles[0].getTopPos() == 1028 || (obstacles[1].getTopPos() < 1570 && obstacles[1].getTopPos() > -70)) {
            obstacles[1].move(-12);
        }
        else {
            obstacles[1] = ObjectFactory.getNewObstacle();
        }
        if (obstacles[1].getTopPos() == 1028 || (obstacles[2].getTopPos() < 1570 && obstacles[2].getTopPos() > -70)) {
            obstacles[2].move(-12);
        }
        else {
            obstacles[2] = ObjectFactory.getNewObstacle();
        }

        //obstacle array for visible objects, once they are not visible, they reset position and objecttype
        //score? move obstacle, if obstacle.getX() < player position, currentScore++;
    }

    public boolean isGameOver(){
        return gameOver;
    }
    public void setGameOver(){
        gameOver = false;
    }

    public void setWaitingForStart(){
        waitingForStart = false;
    }
}



