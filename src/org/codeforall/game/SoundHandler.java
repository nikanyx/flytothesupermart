package org.codeforall.game;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundHandler {

    // Play a sound file
    /*public static void playSound(String soundFilePath) {
        try {
            File soundFile = new File("resources/audio-menu.wav");  // Specify the file path of the Superman theme
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            // Handle any exceptions
        }
    }*/

    // Play background music (looping) in the Main
    public static void playBackgroundMusic(String soundFilePath) {
        try {
            //Declare the soundfile from class File
            File soundFile = new File(soundFilePath);
            //AudioInputStream (audio) like the fileInputStream. AudioSystem to assess the audio data
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            //Clip is the Class that can be use to reload the last file
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);  // Loop the background music
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }


}

