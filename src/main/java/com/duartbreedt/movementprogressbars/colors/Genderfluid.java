package com.duartbreedt.movementprogressbars.colors;

import com.duartbreedt.movementprogressbars.FlagColor;
import com.intellij.ui.Gray;
import com.intellij.ui.JBColor;

import java.awt.*;

public class Genderfluid implements FlagColor {

    private static final Color PINK = JBColor.decode("#FF76A3");
    private static final Color WHITE = new JBColor(Gray._255, Gray._255);
    private static final Color VIOLET = JBColor.decode("#BF11D7");
    private static final Color CHARCOAL = JBColor.decode("#282828");
    private static final Color BLUE = JBColor.decode("#303CBE");

    public Color[] getColors() {
        return new Color[]{PINK, WHITE, VIOLET, CHARCOAL, BLUE};
    }
}
