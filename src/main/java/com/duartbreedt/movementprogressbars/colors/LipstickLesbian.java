package com.duartbreedt.movementprogressbars.colors;

import com.duartbreedt.movementprogressbars.FlagColor;
import com.intellij.ui.JBColor;

import java.awt.*;

public class LipstickLesbian implements FlagColor {

    private static final Color DARK_PINK = JBColor.decode("#A50061");
    private static final Color DULL_PINK = JBColor.decode("#B85493");
    private static final Color PINK = JBColor.decode("#D163A7");
    private static final Color WHITE = JBColor.WHITE;
    private static final Color PALE_PINK = JBColor.decode("#E5AED0");
    private static final Color BLUSH = JBColor.decode("#C64D53");
    private static final Color DEEP_BERRY = JBColor.decode("#8B1800");

    public Color[] getColors() {
        return new Color[]{DARK_PINK, DULL_PINK, PINK, WHITE, PALE_PINK, BLUSH, DEEP_BERRY};
    }
}
