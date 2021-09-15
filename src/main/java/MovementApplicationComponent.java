import com.intellij.ide.ui.LafManager;

import javax.swing.*;

public class MovementApplicationComponent {
    public MovementApplicationComponent() {
        LafManager.getInstance().addLafManagerListener(__ -> updateProgressBarUi());
        updateProgressBarUi();
    }

    private void updateProgressBarUi() {
        UIManager.put("ProgressBarUI", MovementProgressBarUi.class.getName());
        UIManager.getDefaults().put(MovementProgressBarUi.class.getName(), MovementProgressBarUi.class);
    }
}
