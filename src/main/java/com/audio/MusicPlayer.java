/*
 * ShahXVI's implementation of a music player
 */

package com.audio;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.net.URL;

import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.LineUnavailableException;

public class MusicPlayer {
    private URL url = null;
    private AudioInputStream audioStream = null;
    private Clip clip = null;

    public MusicPlayer(String path) {
        try {
            url = getClass().getResource(path);
            audioStream = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to file audio file");
        } catch (UnsupportedAudioFileException e) {
            System.out.println("Audio file is not supported");
        } catch (LineUnavailableException e) {
            System.out.println("Unable to access audio file");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void start() {
        if (clip != null) {
            clip.start();
        }
    }

    public void restart() {
        if (clip != null) {
            clip.stop();
            clip.setFramePosition(0);
            clip.start();
        }
    }

    public void stop() {
        clip.stop();
    }

    public void close() {
        if (clip != null) {
            clip.close();
        }

        try {
            if (audioStream != null) {
                audioStream.close();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
