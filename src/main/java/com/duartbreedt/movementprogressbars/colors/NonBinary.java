package com.duartbreedt.movementprogressbars.colors;

import com.duartbreedt.movementprogressbars.FlagColor;
import com.intellij.ui.JBColor;

import java.awt.*;

public class NonBinary implements FlagColor {

    private static final Color YOLK = JBColor.decode("#FCF431");
    private static final Color WHITE = JBColor.WHITE;
    private static final Color VIOLET = JBColor.decode("#9D58D2");
    private static final Color CHARCOAL = JBColor.decode("#282828");

    public Color[] getColors() {
        return new Color[]{YOLK, WHITE, VIOLET, CHARCOAL};
    }
}
