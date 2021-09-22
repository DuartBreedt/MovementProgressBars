package com.duartbreedt.movementprogressbars.colors;

import com.duartbreedt.movementprogressbars.FlagColor;
import com.intellij.ui.JBColor;

import java.awt.*;

public class Bisexual implements FlagColor {

    // TODO: Fix this to be in the ratios 2/5, 1/5, 2/5

    private static final Color HOT_PINK = JBColor.decode("#D70070");
    private static final Color AUBERGINE = JBColor.decode("#9C4E97");
    private static final Color BLUE = JBColor.decode("#0035A9");

    public Color[] getColors() {
        return new Color[]{HOT_PINK, AUBERGINE, BLUE};
    }
}
