package com.rafayel.gameengine;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class SoundPlayer {
    public static synchronized void playSoundAsync(final String fileName) {
        new Thread(() -> playSound(fileName)).start();
    }

    public static void playSound(String fileName) {
        try {
                Clip clip = AudioSystem.getClip();
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(fileName));
                clip.open(inputStream);
                clip.start();
            } catch (Exception e) {
                System.out.println(e.toString());
                Runtime.getRuntime().exit(1);
            }
    }

    public String toString() {
        return "Sound Player Class";
    }
}
