package com.duartbreedt.movementprogressbars.colors;

import com.duartbreedt.movementprogressbars.FlagColor;
import com.intellij.ui.Gray;
import com.intellij.ui.JBColor;

import java.awt.*;

public class Asexual implements FlagColor {

    private static final Color BLACK = new JBColor(Gray._0, Gray._0);
    private static final Color GRAY = JBColor.decode("#A4A4A4");
    private static final Color WHITE = new JBColor(Gray._255, Gray._255);
    private static final Color PURPLE = JBColor.decode("#810081");

    public Color[] getColors() {
        return new Color[]{BLACK, GRAY, WHITE, PURPLE};
    }
}
