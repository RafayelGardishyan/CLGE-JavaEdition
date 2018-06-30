package com.rafayel.gameengine;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        // Testing Renderer
        Renderer r = new Renderer(20, 20, "#");
        r.setDelay(200);

        //Render an empty screen
        r.render(true, false);

        //Render an animation of moving "i" from the left top corner to the right bottom corner
        for (int i = 0; i < 20; i++) {
            r.addObject(i, i, "i");
            r.render(true, true);
        }

        //Render a rectangle
        r.addRect(1, 19, 1, 19, "X");
        r.render(true, true);

        //Render a string
        r.addString(4, 10, "Hello, World");
        r.render(true, true);
    }
}
