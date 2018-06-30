package com.rafayel.gameengine;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        //// Testing Renderer

        //Create the "Renderer" object
        Renderer r = new Renderer(20, 20, "#");

        //Set delay
        r.setDelay(20);

        //Render an empty screen
        r.render(true, false);

        //Render an animation of moving "i" from the left top corner to the right bottom corner
        for (int i = 0; i < 20; i++) {
            for (int j = 19; j > 0; j--) {
                r.addObject(i, j, "x");
                r.addObject(j, i, "x");
                r.render(true, true);
            }
        }

        //Change size of the field
        r.setSizes(40, 20);

        //Change delay
        r.setDelay(1000);

        //Render a rectangle
        r.addRect(1, 39, 1, 19, "X");
        r.render(true, true);

        //Change the size back
        r.setSizes(20, 20);

        //Render a string
        r.addString(4, 10, "Hello, World");
        r.render(true, false);

        //Add an other string without removing the previous objects
        r.addString(6, 11, "The End!");
        r.render(true, false);
    }
}
