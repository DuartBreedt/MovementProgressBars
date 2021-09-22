package com.duartbreedt.movementprogressbars.colors;

import com.duartbreedt.movementprogressbars.FlagColor;
import com.intellij.ui.Gray;
import com.intellij.ui.JBColor;

import java.awt.*;

public class Aromantic implements FlagColor {

    private static final Color GREEN = JBColor.decode("#3AA640");
    private static final Color LIME = JBColor.decode("#A8D47A");
    private static final Color WHITE = new JBColor(Gray._255, Gray._255);
    private static final Color GRAY = JBColor.decode("#AAAAAB");
    private static final Color BLACK = new JBColor(Gray._0, Gray._0);

    public Color[] getColors() {
        return new Color[]{GREEN, LIME, WHITE, GRAY, BLACK};
    }
}
