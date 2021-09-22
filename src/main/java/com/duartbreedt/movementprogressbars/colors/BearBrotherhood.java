package com.duartbreedt.movementprogressbars.colors;

import com.duartbreedt.movementprogressbars.FlagColor;
import com.intellij.ui.Gray;
import com.intellij.ui.JBColor;

import java.awt.*;

public class BearBrotherhood implements FlagColor {

    private static final Color BROWN = JBColor.decode("#623500");
    private static final Color BURNT_ORANGE = JBColor.decode("#D66300");
    private static final Color SUNSET_YELLOW = JBColor.decode("#FEDE63");
    private static final Color BEIGE = JBColor.decode("#FEE7B9");
    private static final Color WHITE = new JBColor(Gray._255, Gray._255);
    private static final Color GRAY = JBColor.decode("#545454");
    private static final Color BLACK = new JBColor(Gray._0, Gray._0);

    public Color[] getColors() {
        return new Color[]{BROWN, BURNT_ORANGE, SUNSET_YELLOW, BEIGE, WHITE, GRAY, BLACK};
    }
}
