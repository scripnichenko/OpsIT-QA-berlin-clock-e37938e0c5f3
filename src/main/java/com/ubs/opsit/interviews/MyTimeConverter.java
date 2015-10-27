package com.ubs.opsit.interviews;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Андрей
 * Date: 27.10.15
 * Time: 0:52
 * To change this template use File | Settings | File Templates.
 */
public class MyTimeConverter implements TimeConverter {
    @Override
    public String convertTime(String aTime) throws IllegalArgumentException{
        if ((aTime.length()!= 8)) throw new IllegalArgumentException("Time is incorrect. Please, set correct time according to mask HH:mm:ss. Thank you!");

        List<Integer> elements = new ArrayList<Integer>();


            for (String element : aTime.split(":")) {
                elements.add(Integer.valueOf(element));
            }

        if ((elements.get(0)>24)||(elements.get(0)<0))
            throw new IllegalArgumentException("Time is incorrect. Hours has value bigger than '24'. Please, set correct time according to mask HH:mm:ss. Thank you!");
        if ((elements.get(1)>59)||(elements.get(1)<0))
            throw new IllegalArgumentException("Time is incorrect. Minutes has value bigger than '59'. Please, set correct time according to mask HH:mm:ss. Thank you!");
        if ((elements.get(2)>59)||(elements.get(2)<0))
            throw new IllegalArgumentException("Time is incorrect. Seconds has value bigger than '59'. Please, set correct time according to mask HH:mm:ss. Thank you!");

        String totalTable = getYellowLampflag(elements.get(2)) +
                getTopRowOfHrs(elements.get(0))+
                getLowerRowOfHrs(elements.get(0))+
                getTopRowOfMinutes(elements.get(1))+
                getLowerRowOfMinutes(elements.get(1));

        return totalTable;
    }

    protected String getYellowLampflag(int seconds) {
        if (seconds%2 == 0) return "Y";
        else
            return "O";
    }

    protected String getTopRowOfHrs(int hours) {
        int qtyOfRed = (hours - (hours%5))/5;
        String topRowOfHrs = "";
        for(int i = 0; i<4; i++){
            if (qtyOfRed>i) topRowOfHrs += "R";
                else topRowOfHrs+= "O";
        }
        return topRowOfHrs;
    }

    protected String getLowerRowOfHrs(int hours) {
        String lowRowOfHrs = "";
        for(int i = 0; i<4; i++){
            if (((hours%5)>i)) lowRowOfHrs += "R";
            else lowRowOfHrs+= "O";
        }
        return lowRowOfHrs;

    }

    protected String getTopRowOfMinutes(int minutes) {
        int qtyOfTop = (minutes - (minutes%5))/5;
        String topRowOfMts = "";
        for(int i = 0; i<11; i++){
            if ((qtyOfTop>i)&&((i==2)||(i==5)||(i==8))) topRowOfMts += "R";
            else
            if (qtyOfTop>i) topRowOfMts+="Y";
            else topRowOfMts+= "O";
        }
        return topRowOfMts;

    }

    protected String getLowerRowOfMinutes(int minutes) {
        String lowRowOfMts = "";
        for(int i = 0; i<4; i++){
            if (((minutes%5)>i)) lowRowOfMts += "Y";
            else lowRowOfMts+= "O";
        }
        return lowRowOfMts;

    }

}
