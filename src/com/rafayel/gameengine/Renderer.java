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

    public void addObject(Integer x, Integer y){
        //Add an object containing the standard symbol to the screen
        addObject(x, y, std);
    }

    public void addObject(ScreenObject so){
        //Add an existing "ScreenObject" instance to the screen
        objects.add(so);
    }

    public void addRect(Integer x1, Integer x2, Integer y1, Integer y2, String symbol){
        //Add a rectangle to the screen
        for (int i=0; i < Math.abs(x1 - x2); i++){
            for (int j=0; j < Math.abs(y1 - y2); j++){
                addObject(x1 + i, y1 + j, symbol);
            }
        }
    }

    public void addRect(Integer x1, Integer x2, Integer y1, Integer y2){
        //Add a rectangle containing the standard symbol to the screen
        addRect(x1, x2, y1, y2, std);
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
      Boolean obj_set = false;
      for (ScreenObject so : objects){
                    //Check object x and y position and compare it with cursor x and y
                    if (so.getXpos() == j && so.getYpos() == i){
                        frame += so.getSymbol();
                        obj_set = true;
                        break;
                    }
                }

                //If no object is set in the frame: add a space
                if (!obj_set){frame += " ";}else{obj_set = false;}
      return frame;
    }

    public void render(Boolean clear_screen, Boolean clear_objects) throws InterruptedException {
        //Clear console screen of the option is enabled
        if (clear_screen){clearConsole();}

        //Initializing variables
        String frame = "";

        //Add border top
        for (int x = 0; x < sizes.get("width") + 2; x++){frame += std;}

        //Shit to the first row
        frame += "\n";

        //Render Screen Objects
        for (int i=0; i < sizes.get("height"); i++){
            //Add row left border
            frame += std;
            for (int j=0; j < sizes.get("width"); j++){
                frame = checkElements(i, j, frame);
            }
            //Add row right border; Shift to the next row
            frame += std + "\n";
        }

        //Add border bottom
        for (int x = 0; x < sizes.get("width") + 2; x++){frame += std;}

        //Print the frame
        System.out.println(frame);

        //Do the optional options
        Utils.delay(_delay);
        if (clear_objects){clearScreen();}
    }

    public String toString() {
        return "Renderer Class";
    }
}
