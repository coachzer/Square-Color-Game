package com.kovacevic;

import java.awt.*;
import java.util.*;

public class Colors {

    ArrayList<Color> colors;
    public Colors() {

        Color myBlue = new Color(32, 100, 232);
        Color myRed = new Color(191, 79, 79);
        Color myYellow = new Color(242, 230, 63);
        Color myGreen = new Color(135, 160, 103);
        Color myWhite = new Color(232, 229, 229);

        colors = new ArrayList<>();
        colors.add(myYellow);
        colors.add(myRed);
        colors.add(myBlue);
        colors.add(myGreen);
        colors.add(myWhite);
    }

    public Color rotation() {

        Random c = new Random();
        return colors.get(c.nextInt(colors.size()));
    }
}