package org.codeforall.game;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class FileManager {

    public void saveHighScore(String highscore) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(Game.IMGPREFIX + "highscore.txt", false));
            bw.write("" + highscore);
            bw.flush();
            bw.close();
        } catch (IOException e) {
        }
    }

        public int loadHighScore(){
            BufferedReader br = null;
            String line = "";
            int number;
            try {
                br = new BufferedReader(new FileReader(Game.IMGPREFIX + "highscore.txt"));
                line = br.readLine();
                br.close();
            } catch (IOException e) {
                line = "";
            }
            try {
                number = Integer.valueOf(line);
                System.out.println("Converted integer: " + number);
            } catch (NumberFormatException e) {
                number = 0;
            }
            return number;
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
