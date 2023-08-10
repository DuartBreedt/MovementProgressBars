package com.duartbreedt.movementprogressbars.actions;

import com.duartbreedt.movementprogressbars.FlagColor;
import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class SetFlagToShuffleAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        PropertiesComponent.getInstance().setValue(FlagColor.PROPERTY_KEY, "Shuffle");
    }

    @Override
    public boolean isDumbAware() {
        return super.isDumbAware();
    }
}