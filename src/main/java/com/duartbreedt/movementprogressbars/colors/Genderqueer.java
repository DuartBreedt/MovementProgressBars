package com.duartbreedt.movementprogressbars.colors;

import com.duartbreedt.movementprogressbars.FlagColor;
import com.intellij.ui.JBColor;

import java.awt.*;

public class Genderqueer implements FlagColor {

    private static final Color MAUVE = JBColor.decode("#B67FDD");
    private static final Color WHITE = JBColor.WHITE;
    private static final Color PICKLE = JBColor.decode("#48821E");

    public Color[] getColors() {
        return new Color[]{MAUVE, WHITE, PICKLE};
    }
}
