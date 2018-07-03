package com.rafayel.gameengine;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class TestModules {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
    @Test
    public void testScreenObject(){
        ScreenObject so = new ScreenObject(10, 21, "x");

        assertEquals(Integer.valueOf(10), so.getXpos());
        assertEquals(Integer.valueOf(21), so.getYpos());
        assertEquals(String.valueOf("x"), so.getSymbol());
    }

    @Test
    public void testRendererObject() throws InterruptedException {
        String example = "#####\n" +
                         "#   #\n" +
                         "# # #\n" +
                         "#   #\n" +
                         "#####";

        Renderer r = new Renderer(3, 3, "#");
                 r.addObject(1, 1, "#");
                 r.render(false, false);
        assertEquals(example, outContent.toString());
    }

    @Test
    public void testRendererRect() throws InterruptedException{
        String example = "#####\n" +
                         "#####\n" +
                         "#####\n" +
                         "#####\n" +
                         "#####";

        Renderer r = new Renderer(3, 3, "#");
        Integer[] sp = new Integer[2]; Integer[] ep = new Integer[2];
        sp[0] = 0; sp[1] = 0;
        ep[0] = 2; ep[1] = 2;
        r.addRect(sp, ep, "#");
        r.render(false, false);
        assertEquals(example, outContent.toString());
    }

//    @Test
//    public void testSoundPlayer(){
//
//    }
}
