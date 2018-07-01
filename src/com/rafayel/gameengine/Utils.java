package com.rafayel.gameengine;

import java.util.concurrent.TimeUnit;

public class Utils {
    public static void Delay(Integer millis) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(millis);
    }
}
