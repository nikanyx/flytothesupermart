package org.codeforall.game;


import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;


public class SoundHandler {

    private Clip clip;

    public SoundHandler(String path) {
        initClip(path);
    }


    private void initClip(String path) {
        try {
            File sound = new File(path); // intellij only
            // jar only [start]
            /*
            path = "/" + path;
            InputStream is = SoundHandler.class.getResourceAsStream(path);
            if (is == null) {
                throw new RuntimeException("Resource not found: " + path);
            }
            InputStream sound = new BufferedInputStream(is);
            */
            // jar only [end]
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(sound);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
            ex.printStackTrace();
        }
    }

    public void play() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        clip.start();
    }

    public void stop() {
        clip.setFramePosition(0);
        clip.stop();
    }
}

