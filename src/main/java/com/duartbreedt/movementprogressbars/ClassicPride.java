package com.duartbreedt.movementprogressbars;

import com.intellij.ui.JBColor;

import java.awt.*;

public class ClassicPride implements FlagColor {

    private static final Color RED = new JBColor(new Color(221, 3, 3), new Color(221, 3, 3));
    private static final Color ORANGE = new JBColor(new Color(247, 136, 0), new Color(247, 136, 0));
    private static final Color YELLOW = new JBColor(new Color(247, 230, 0), new Color(247, 230, 0));
    private static final Color GREEN = new JBColor(new Color(0, 124, 37), new Color(0, 124, 37));
    private static final Color BLUE = new JBColor(new Color(0, 75, 247), new Color(0, 75, 247));
    private static final Color VIOLET = new JBColor(new Color(113, 7, 131), new Color(113, 7, 131));

    public Color[] getColors() {
        return new Color[]{RED, ORANGE, YELLOW, GREEN, BLUE, VIOLET};
    }
}
