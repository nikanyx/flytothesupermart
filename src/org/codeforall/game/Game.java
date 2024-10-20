package org.codeforall.game;

import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {
    public static final String IMGPREFIX = ""; //empty string for jar, resources/ for intellij
    //public static final String IMGPREFIX = "/Users/codecadet/workspace/yellowgame/untitled-yellow-game/resources/"; //rui
    public static final int MAXX = 1580;
    public static final int MAXY = 1020;
    private static int highScore = 0;
    private int currentScore = 0;
    private int delay = 25;
    private Background bg;
    private Player player;
    private CollisionDetector collisionDetector;
    private Obstacle[] obstacles = new Obstacle[3];
    private ScoreData score = new ScoreData();
    private FileManager fileManager = new FileManager(score);
    private Picture menu;
    private SoundHandler menuMusic;
    private SoundHandler gameMusic;
    private boolean waitingForStart = true;

    public Game(){
        Canvas.setMaxX(MAXX);
        Canvas.setMaxY(MAXY);
    }

    public void init(){
        bg = new Background(0);
        player = new Player();
        new MyKeyboardHandler(player,this);
        collisionDetector = new CollisionDetector(player);
        menu = new Picture(550,375,Game.IMGPREFIX + "start.png");
        menuMusic = new SoundHandler(Game.IMGPREFIX + "audio-menu.wav");
        gameMusic = new SoundHandler(Game.IMGPREFIX + "audio-game.wav");
        start();
    }

    private void start() {
        //generate obstacles
        for (int i = 0; i < obstacles.length; i++){
            obstacles[i] = ObjectFactory.getNewObstacle();
        }

        //run game
        while (true) {
            try {
                // Pause for a while
                Thread.sleep(delay);
                if (waitingForStart){
                    menu.draw();
                    //play menu music
                    menuMusic.play();
                }
                else {
                    menu.delete();

                    //stop menu music, play game music
                    menuMusic.stop();
                    gameMusic.play();

                    //score
                    score.highScore();
                    score.currentScore();

                    //bgImg.move();
                    moveObstacles();

                    //check for collisions
                    for (Obstacle obs : obstacles) {
                        if (collisionDetector.check(obs.getTopObsPosition()) || collisionDetector.check(obs.getBotObsPosition())) {
                            gameMusic.stop();

                            //reset obstacles
                            resetObstacles();

                            //return to menu
                            waitingForStart = true;

                            //Use Date for currentScore when start and when end: (int)((endDate.getTime() - startDate.getTime()) / 1000)
                            score.updateHighScore();

                            break;
                        }
                    }
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void moveObstacles(){
        //obstacle array for visible objects; once they are not visible, they are instantiated with new Position and Type
        if (obstacles[0].getTopPos() > -70) {
            obstacles[0].move(-12);
        }
        else {
            obstacles[0].cleanObsImg();
            obstacles[0] = ObjectFactory.getNewObstacle();
        }
        if (obstacles[0].getTopPos() == 1028 || (obstacles[1].getTopPos() < 1570 && obstacles[1].getTopPos() > -70)) {
            obstacles[1].move(-12);
        }
        else {
            obstacles[1].cleanObsImg();
            obstacles[1] = ObjectFactory.getNewObstacle();
        }
        if (obstacles[1].getTopPos() == 1028 || (obstacles[2].getTopPos() < 1570 && obstacles[2].getTopPos() > -70)) {
            obstacles[2].move(-12);
        }
        else {
            obstacles[2].cleanObsImg();
            obstacles[2] = ObjectFactory.getNewObstacle();
        }
    }

    private void resetObstacles(){
        for (int i = 0; i < obstacles.length; i++){
            obstacles[i].cleanObsImg();
            obstacles[i] = ObjectFactory.getNewObstacle();
        }
    }

    public void setWaitingForStart(){
        waitingForStart = false;
    }
}
