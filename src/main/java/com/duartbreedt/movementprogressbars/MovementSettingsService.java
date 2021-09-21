package com.duartbreedt.movementprogressbars;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.components.StoragePathMacros;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

@State(name = "MovementSettingsService", storages = @Storage(value = "$APP_CONFIG$/movementSettings.xml"))
public class MovementSettingsService implements PersistentStateComponent<MovementSettingsService.State> {

    private State state = new State();

    @Override
    public MovementSettingsService.State getState() {
        return state;
    }

    @Override
    public void loadState(@NotNull State state) {
        this.state = state;
    }

    static class State {
        public Color[] colors;
    }
}
