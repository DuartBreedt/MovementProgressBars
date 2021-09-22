package com.duartbreedt.movementprogressbars.colors;

import com.duartbreedt.movementprogressbars.FlagColor;
import com.intellij.ui.JBColor;

import java.awt.*;

public class Pansexual implements FlagColor {

    private static final Color VIVID_PINK = JBColor.decode("#FF1B8D");
    private static final Color DIRTY_YELLOW = JBColor.decode("#FFD900");
    private static final Color SKY = JBColor.decode("#1BB2FF");

    public Color[] getColors() {
        return new Color[]{VIVID_PINK, DIRTY_YELLOW, SKY};
    }
}
