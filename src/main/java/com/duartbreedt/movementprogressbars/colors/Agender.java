package com.duartbreedt.movementprogressbars.colors;

import com.duartbreedt.movementprogressbars.FlagColor;
import com.intellij.ui.Gray;
import com.intellij.ui.JBColor;

import java.awt.*;

public class Agender implements FlagColor {

    private static final Color BLACK = new JBColor(Gray._0, Gray._0);
    private static final Color GRAY = new JBColor(Gray._186, Gray._186);
    private static final Color WHITE = new JBColor(Gray._255, Gray._255);
    private static final Color GREEN = new JBColor(new Color(185, 244, 132), new Color(185, 244, 132));

    public Color[] getColors() {
        return new Color[]{BLACK, GRAY, WHITE, GREEN, WHITE, GRAY, BLACK};
    }
}
