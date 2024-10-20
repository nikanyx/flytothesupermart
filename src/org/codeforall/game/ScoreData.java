package org.codeforall.game;


import org.academiadecodigo.simplegraphics.graphics.Text;

public class ScoreData{

    private int i = -1;
    private int cScore = 0;
    private int hScore = 0;
    private FileManager scoreUpdate = new FileManager();

    private Text currentScore = new Text(50, 70, "         SCORE: ");
    private Text highScore = new Text(50, 30, "HIGHSCORE: ");

    public void highScore() {
        String hs = Integer.toString(hScore);
        highScore.draw();
        highScore.setText("HIGHSCORE: " + hs);
        if(i < 0) {
            highScore.grow(25, 16);
        }
    }

    public void currentScore(){
        String cs = Integer.toString(cScore);
        currentScore.draw();
        currentScore.setText("        SCORE: " + cs);
        if(i < 0) {
            currentScore.grow(25, 16);
        }
        i++;
        cScore = i/10;
    }

    public void updateHighScore(){
        if (cScore > hScore) {
            hScore = cScore;
            highScore();
            scoreUpdate.saveHighScore(Integer.toString(hScore));
        }
        cScore = 0;
        i = 0;
    }

    public void loadHighScore() {
        hScore = scoreUpdate.loadHighScore();
    }
}

