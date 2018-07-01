package com.rafayel.gameengine;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class SoundPlayer {
    public static synchronized void PlaySound(final String fileName) {
        new Thread(() -> {
            try {
                Clip clip = AudioSystem.getClip();
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(fileName));
                clip.open(inputStream);
                clip.start();
            } catch (Exception e) {
                System.out.println(e.toString());
                System.exit(1);
            }
        }).start();
    }

    public String toString() {
        return "Sound Player Class";
    }
}
