package org.codeforall.game;

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
            } catch (NumberFormatException e) {
                number = 0;
            }
            return number;
        }
}
