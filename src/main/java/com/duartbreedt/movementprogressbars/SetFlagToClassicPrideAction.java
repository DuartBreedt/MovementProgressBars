package com.duartbreedt.movementprogressbars;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class SetFlagToClassicPrideAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
//        MovementSettingsService service = ApplicationManager.getApplication().getService(MovementSettingsService.class);
//        MovementSettingsService.State state = service.getState();
//        if(state != null) {
//            state.colors = ClassicPride.getColors();
//        }

        PropertiesComponent.getInstance().setValue(FlagColor.PROPERTY_KEY, ClassicPride.class.getName());
    }

    @Override
    public boolean isDumbAware() {
        return super.isDumbAware();
    }
}
