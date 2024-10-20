package org.codeforall.game;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class FileManager {
    public void saveHighScore() {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("highscore.txt", false));
            bw.write("" + ScoreData.getHighScore());
            bw.flush();
            bw.close();
        } catch (IOException e) {
        }
    }

        public void loadHighScore(){
            BufferedReader br = null;
            String line = "";
            try {
                br = new BufferedReader(new FileReader("highscore.txt"));
                line = br.readLine();
                br.close();
            } catch (IOException e) {
                line = "";
            }
        }

    /*
    int highScore;

    FileOutputStream topScore;

    {
        try {
            topScore = new FileOutputStream("score.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    String temp = Integer.toString(ScoreData.getHighScore());
    byte[] buffer = temp.getBytes();
    topScore.write(buffer);
    topScore.close(); */
}
