package com.rafayel.gameengine;

public class ScreenObject {
    private Integer xpos;
    private Integer ypos;
    private String thisSymbol;

    ScreenObject(Integer x, Integer y, String symbol){
        xpos = x;
        ypos = y;
        thisSymbol = symbol;
    }

    public Integer getXpos(){
        return xpos;
    }
    public Integer getYpos(){
        return ypos;
    }
    public String getSymbol(){
        return thisSymbol;
    }
}
