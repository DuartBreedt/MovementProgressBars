package com.duartbreedt.movementprogressbars;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(
        name = "com.duartbreedt.movementprogressbars.MovementSettingsState",
        storages = @Storage("SdkSettingsPlugin.xml")
)
public class MovementSettingsState implements PersistentStateComponent<MovementSettingsState> {

    private FlagColor progressBarFlag = FlagColor.DEFAULT_VALUE;

    public static MovementSettingsState getInstance() {
        return ApplicationManager.getApplication().getService(MovementSettingsState.class);
    }

    @Override
    public @Nullable MovementSettingsState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull MovementSettingsState state) {
        XmlSerializerUtil.copyBean(state, this);
    }

    public FlagColor getProgressBarFlag() {
        return progressBarFlag;
    }

    public void setProgressBarFlag(FlagColor progressBarFlag) {
        this.progressBarFlag = progressBarFlag;
    }
}
