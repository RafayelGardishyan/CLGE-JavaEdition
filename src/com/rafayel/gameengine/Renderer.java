package com.rafayel.gameengine;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Renderer {
    private List<ScreenObject> objects;
    private Hashtable<String, Integer> sizes = new Hashtable<>();
    private String std;
    private Integer _delay = 0;
    private String spacer = "";

    Renderer (Integer field_width, Integer field_height, String std_char){
        objects = new ArrayList<>();
        std = Character.toString(std_char.charAt(0));
        sizes.put("width", field_width);
        sizes.put("height", field_height);
        for (int i = 0; i < 100; i++) {
            spacer += "\n";
        }
    }

    public void setDelay(Integer milliseconds){
        _delay = milliseconds;
    }

    public void setStdChar(String std_char) {
        std = std_char;
    }

    public void setSizes(Integer width, Integer height){
        sizes.put("width", width);
        sizes.put("height", height);
    }

    public void addObject(Integer x, Integer y, String symbol){
        //Add an object to the screen
        if (x < sizes.get("width") && y < sizes.get("height")){objects.add(new ScreenObject(x, y, Character.toString(symbol .charAt(0))));}
    }

    public void addRect(Integer[] StartPoints, Integer[] EndPoints, String symbol) {
        /* StartPoints = [x1, y1]
         * EndPoints   = [x2, y2]
         * Symbol      = "C"
         */
        //Add a rectangle to the screen
        for (int i = 0; i <= Math.abs(StartPoints[0] - EndPoints[0]); i++) {
            for (int j = 0; j <= Math.abs(StartPoints[1] - EndPoints[1]); j++) {
                addObject(StartPoints[0] + i, StartPoints[1] + j, symbol);
            }
        }
    }

    public void addString(Integer x, Integer y, String string) {
        for (int i = 0; i < string.length(); i++) {
            addObject(x + i, y, Character.toString(string.charAt(i)));
        }
    }

    private void clearScreen(){
        //Clear all objects from the screen
        objects.clear();
    }

    private void clearConsole(){
        System.out.print(spacer);
    }

    private String checkElements(Integer i, Integer j, String frame){
        String tmpframe = frame;
        Boolean obj_set = false;
        for (ScreenObject so : objects){
            //Check object x and y position and compare it with cursor x and y
            if (so.getXpos().equals(j) && so.getYpos().equals(i)){
                tmpframe += so.getSymbol();
                obj_set = true;
                break;
            }
         }

         //If no object is set in the frame: add a space
         if (!obj_set) tmpframe += " "; else obj_set = false;
         return tmpframe;
    }

    private String getFrame(String frame){
        String _frame = frame;
        //Add border top
        for (int x = 0; x < sizes.get("width") + 2; x++) _frame += std;

        //Shift to the first row
        _frame += "\n";

        //Render Screen Objects
        for (int i=0; i < sizes.get("height"); i++){
            //Add row left border
            _frame += std;
            for (int j=0; j < sizes.get("width"); j++){
                _frame = checkElements(i, j, _frame);
            }
            //Add row right border; Shift to the next row
            _frame += std + "\n";
        }

        //Add border bottom
        for (int x = 0; x < sizes.get("width") + 2; x++) _frame += std;

        return _frame;
    }

    public void render(Boolean clear_screen, Boolean clear_objects) throws InterruptedException {
        //Clear console screen of the option is enabled
        if (clear_screen) clearConsole();

        //Initializing variables
        String frame = getFrame("");

        //Print the frame
        System.out.print(frame);

        //Do the optional options
        Utils.delay(_delay);
        if (clear_objects) clearScreen();
    }
}
