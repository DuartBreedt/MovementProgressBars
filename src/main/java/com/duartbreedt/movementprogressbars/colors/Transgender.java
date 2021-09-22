package com.duartbreedt.movementprogressbars.colors;

import com.duartbreedt.movementprogressbars.FlagColor;
import com.intellij.ui.Gray;
import com.intellij.ui.JBColor;

import java.awt.*;

public class Transgender implements FlagColor {

    private static final Color BLUE = new JBColor(new Color(91, 206, 250), new Color(91, 206, 250));
    private static final Color PINK = new JBColor(new Color(245, 169, 184), new Color(245, 169, 184));
    private static final Color WHITE = new JBColor(Gray._255, Gray._255);

    public Color[] getColors() {
        return new Color[]{BLUE, PINK, WHITE, PINK, BLUE};
    }
}
