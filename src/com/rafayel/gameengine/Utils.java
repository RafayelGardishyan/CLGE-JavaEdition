package com.rafayel.gameengine;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Utils {
    public static void delay(Integer millis) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(millis);
    }

    public static int random(Integer a, Integer b) {
        return ThreadLocalRandom.current().nextInt(a, b + 1);
    }
}
