package com.duartbreedt.movementprogressbars.colors;

import com.duartbreedt.movementprogressbars.FlagColor;
import com.intellij.ui.Gray;
import com.intellij.ui.JBColor;

import java.awt.*;

public class Leather implements FlagColor {

    private static final Color BLACK = new JBColor(Gray._0, Gray._0);
    private static final Color DENIM = JBColor.decode("#252580");
    private static final Color WHITE = new JBColor(Gray._255, Gray._255);

    public Color[] getColors() {
        return new Color[]{BLACK, DENIM, BLACK, DENIM, WHITE, DENIM, BLACK, DENIM, BLACK};
    }
}
