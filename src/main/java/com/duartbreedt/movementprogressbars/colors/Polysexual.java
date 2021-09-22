package com.duartbreedt.movementprogressbars.colors;

import com.duartbreedt.movementprogressbars.FlagColor;
import com.intellij.ui.JBColor;

import java.awt.*;

public class Polysexual implements FlagColor {

    private static final Color VIVID_PINK = JBColor.decode("#F615BA");
    private static final Color ALGAE = JBColor.decode("#01D669");
    private static final Color BLUE = JBColor.decode("#1593F6");

    public Color[] getColors() {
        return new Color[]{VIVID_PINK, ALGAE, BLUE};
    }
}
