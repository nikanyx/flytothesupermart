package org.codeforall.game;

import org.academiadecodigo.simplegraphics.graphics.Canvas;


public class Game{
    public static final String IMGPREFIX = "resources/"; //empty string for jar, resources/ for intellij
    //public static final String IMGPREFIX = "/Users/codecadet/workspace/yellowgame/untitled-yellow-game/resources/"; //rui
    public static final int MAXX = 1280;
    public static final int MAXY = 720;
    private int delay = 25;
    private Background bg;
    private Player player;
    private CollisionDetector collisionDetector;
    private Obstacle[] obstacles = new Obstacle[2];
    private ScoreData score = new ScoreData();
    private FileManager fileManager = new FileManager(score);
    private Menu menu;
    private SoundHandler menuMusic;
    private SoundHandler lostMusic;
    private SoundHandler gameMusic;
    private int waitingForStart = 1;

    public Game(){
        Canvas.setMaxX(MAXX);
        Canvas.setMaxY(MAXY);
    }

    public void init(){
        bg = new Background(0);
        player = new Player();
        new MyKeyboardHandler(player,this);
        collisionDetector = new CollisionDetector(player);
        menu = new Menu();
        menuMusic = new SoundHandler(Game.IMGPREFIX + "audio-menu.wav");
        gameMusic = new SoundHandler(Game.IMGPREFIX + "audio-game.wav");
        lostMusic = new SoundHandler(Game.IMGPREFIX + "babylost.wav");
        start();
    }

    private void start() {
        //generate obstacles
        for (int i = 0; i < obstacles.length; i++){
            obstacles[i] = ObjectFactory.getNewObstacle();
            System.out.println(obstacles[i].getBotObsPosition().getYPos());
        }

        //run game
        while (true) {
            try {
                // Pause for a while
                Thread.sleep(delay);
                if (waitingForStart == 1){
                    menu.showMenu();
                    //play menu music
                    menuMusic.play();

                }
                else if(waitingForStart == 0) {
                    menu.hide();
                    menu.hideLose();

                    //stop menu music, play game music
                    menuMusic.stop();
                    lostMusic.stop();
                    gameMusic.play();

                    //score
                    score.highScore();
                    score.currentScore();

                    //bgImg.move();
                    moveObstacles();

                    //check for collisions
                    for (Obstacle obs : obstacles) {
                        if (collisionDetector.check(obs.getTopObsPosition()) || collisionDetector.check(obs.getBotObsPosition())) {
                            waitingForStart = 2;

                            //reset obstacles
                            for (Obstacle obst : obstacles) {
                                obst.resetObstacle();
                            }

                            break;
                        }
                    }
                }
                else {
                    gameMusic.stop();
                    lostMusic.play();

                    //shows lost screen
                    menu.showLose();

                    //update highscore if lower than current score
                    score.updateHighScore();
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void moveObstacles(){
        //obstacle movement; once they are not visible, obstacletype and obstacleposition are reset
        for (int i = 0; i < obstacles.length; i++) {

            if ((i == 0 && obstacles[0].getTopPos() > -70) ||
                    (i != 0 && obstacles[i-1].getTopPos() == 644) ||
                    (obstacles[i].getTopPos() < 1280 && obstacles[i].getTopPos() > -70)){
                obstacles[i].move(-12);
            }
            else if (obstacles[i].getTopPos() < -70){
                obstacles[i].resetObstacle();
                System.out.println(obstacles[i].getBotObsPosition().getYPos());
            }
        }
    }

    public int getWaitingForStart() {
        return waitingForStart;
    }

    public void setWaitingForStart(int i){
        waitingForStart = i;
    }
}
