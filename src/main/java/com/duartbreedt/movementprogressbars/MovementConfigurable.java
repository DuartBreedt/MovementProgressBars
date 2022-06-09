package com.duartbreedt.movementprogressbars;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.JComponent;
import java.util.Objects;

public class MovementConfigurable implements Configurable {

    private MovementSettingsComponent component;

    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return "Movement";
    }

    @Override
    public JComponent getPreferredFocusedComponent() {
        return component.getPreferredFocusedComponent();
    }

    @Override
    public @Nullable JComponent createComponent() {
        component = new MovementSettingsComponent();
        return component.getPanel();
    }

    @Override
    public boolean isModified() {
        MovementSettingsState settings = MovementSettingsState.getInstance();
        return !Objects.equals(settings.getProgressBarFlag(), component.getProgressBarFlag());
    }

    @Override
    public void apply() throws ConfigurationException {
        MovementSettingsState settings = MovementSettingsState.getInstance();
        settings.setProgressBarFlag(component.getProgressBarFlag());
    }

    @Override
    public void disposeUIResources() {
        component = null;
    }
}
