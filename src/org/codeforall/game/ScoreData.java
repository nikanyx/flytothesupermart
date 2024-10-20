package org.codeforall.game;


import org.academiadecodigo.simplegraphics.graphics.Text;

public class ScoreData{

    int  i = 0;
    static int hScore = 0;
    Text currentScore = new Text(50, 70, "         SCORE: ");
    Text highScore = new Text(50, 30, "HIGHSCORE: ");

    public void highScore() {
        String hs = Integer.toString(hScore);
        highScore.draw();
        highScore.setText("HIGHSCORE: " + hs);
        if(i == 0) {
            highScore.grow(25, 16);
        }

    }
    public void currentScore(){
        String cs = Integer.toString(i/10);
        currentScore.draw();
        currentScore.setText("        SCORE: " + cs);
        if(i == 0) {
            currentScore.grow(25, 16);
        }
        i ++;
        if (i/10 > hScore) {
            hScore = i/10;
        }
    }

    public static int getHighScore() {
            return hScore;
        }
}

