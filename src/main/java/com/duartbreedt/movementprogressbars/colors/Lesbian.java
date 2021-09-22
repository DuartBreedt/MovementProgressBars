package com.duartbreedt.movementprogressbars.colors;

import com.duartbreedt.movementprogressbars.FlagColor;
import com.intellij.ui.Gray;
import com.intellij.ui.JBColor;

import java.awt.*;

public class Lesbian implements FlagColor {

    private static final Color STRAWBERRY = JBColor.decode("#D62900");
    private static final Color APRICOT = JBColor.decode("#FF9B55");
    private static final Color WHITE = new JBColor(Gray._255, Gray._255);
    private static final Color PINK = JBColor.decode("#D462A5");
    private static final Color DARK_PINK = JBColor.decode("#A40062");

    public Color[] getColors() {
        return new Color[]{STRAWBERRY, APRICOT, WHITE, PINK, DARK_PINK};
    }
}
