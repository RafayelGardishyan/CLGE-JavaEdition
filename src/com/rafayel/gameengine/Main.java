package com.rafayel.gameengine;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ////Testing Utilities
        Utils.delay(1000);
        for (int i = 0; i < 10; i++) System.out.println(Utils.random(i, 100 + i));

        ////Testing Sound Player

        //Play Sound (Not Async)
        SoundPlayer.playSound("C:\\Users\\rgard\\Github\\CLGE\\snake_sound\\level_up.wav");
        Utils.delay(1000);

        //Play Sound (Async)
        SoundPlayer.playSoundAsync("C:\\Users\\rgard\\Github\\CLGE\\snake_sound\\level_up.wav");

        //// Testing Renderer

        //Create the "Renderer" object
        Renderer r = new Renderer(20, 20, "#");

        //Set delay
        r.setDelay(40);

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

        //Change the standard char
        r.setStdChar("O");

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
