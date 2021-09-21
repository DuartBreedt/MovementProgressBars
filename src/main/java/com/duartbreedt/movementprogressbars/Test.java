package com.duartbreedt.movementprogressbars;

import com.intellij.ui.JBColor;

import java.awt.*;

public class Test implements FlagColor {

    private static final Color RED = new JBColor(new Color(221, 3, 3), new Color(221, 3, 3));

    public Color[] getColors() {
        return new Color[]{RED};
    }
}
