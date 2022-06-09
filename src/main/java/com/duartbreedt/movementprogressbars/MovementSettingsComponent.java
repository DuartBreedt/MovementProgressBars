package com.duartbreedt.movementprogressbars;

import com.intellij.ui.components.JBLabel;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.util.Arrays;

public class MovementSettingsComponent {

    private final JPanel mainPanel;
    private final JComboBox<FlagColor> progressBarFlagComboBox;

    public MovementSettingsComponent() {
        // FormBuilder.addComponent and such accept JComponent,
        // so I guess we're stuck with deprecated API.
        //noinspection UndesirableClassUsage
        progressBarFlagComboBox = new JComboBox<>();
        Arrays.asList(FlagColor.values()).forEach(progressBarFlagComboBox::addItem);
        progressBarFlagComboBox.setSelectedItem(MovementSettingsState.getInstance().getProgressBarFlag());

        mainPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(new JBLabel("Progress bar flag: "), progressBarFlagComboBox, 1, false)
                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();
    }

    public JPanel getPanel() {
        return mainPanel;
    }

    public JComponent getPreferredFocusedComponent() {
        return progressBarFlagComboBox;
    }

    @NotNull
    public FlagColor getProgressBarFlag() {
        //noinspection ConstantConditions
        return (FlagColor) progressBarFlagComboBox.getSelectedItem();
    }
}
