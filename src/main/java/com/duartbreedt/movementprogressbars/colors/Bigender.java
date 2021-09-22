package com.duartbreedt.movementprogressbars.colors;

import com.duartbreedt.movementprogressbars.FlagColor;
import com.intellij.ui.Gray;
import com.intellij.ui.JBColor;

import java.awt.*;

public class Bigender implements FlagColor {

    private static final Color DARK_PINK = JBColor.decode("#C57AA3");
    private static final Color PINK = JBColor.decode("#EEA6CE");
    private static final Color MAUVE = JBColor.decode("#D6C8E9");
    private static final Color WHITE = new JBColor(Gray._255, Gray._255);
    private static final Color SKY = JBColor.decode("#9BC8E9");
    private static final Color BLUE = JBColor.decode("#6D83D2");

    public Color[] getColors() {
        return new Color[]{DARK_PINK, PINK, MAUVE, WHITE, MAUVE, SKY, BLUE};
    }
}
