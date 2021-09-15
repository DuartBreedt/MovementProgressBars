package com.duartbreedt.movementprogressbars;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class SetFlagToClassicPrideAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        // TODO: Store selection in persistence
    }

    @Override
    public boolean isDumbAware() {
        return super.isDumbAware();
    }
}
