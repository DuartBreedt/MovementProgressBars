package com.duartbreedt.movementprogressbars.colors;

import com.duartbreedt.movementprogressbars.FlagColor;
import com.intellij.ui.Gray;
import com.intellij.ui.JBColor;

import java.awt.*;

public class GayMen implements FlagColor {

    private static final Color FOREST = JBColor.decode("#018E70");
    private static final Color ALGAE = JBColor.decode("#21CFAC");
    private static final Color LIME = JBColor.decode("#9AE9C3");
    private static final Color WHITE = new JBColor(Gray._255, Gray._255);
    private static final Color SKY = JBColor.decode("#7CAFE4");
    private static final Color LAVENDER = JBColor.decode("#4F47CC");
    private static final Color PURPLE = JBColor.decode("#3C1379");

    public Color[] getColors() {
        return new Color[]{FOREST, ALGAE, LIME, WHITE, SKY, LAVENDER, PURPLE};
    }
}
