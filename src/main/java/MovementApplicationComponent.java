import com.intellij.ide.ui.LafManagerListener;
import com.intellij.openapi.application.ApplicationManager;

import javax.swing.*;

public class MovementApplicationComponent {
    public MovementApplicationComponent() {
        ApplicationManager
                .getApplication()
                .getMessageBus()
                .connect()
                .subscribe(LafManagerListener.TOPIC, __ -> updateProgressBarUi());
        updateProgressBarUi();
    }

    private void updateProgressBarUi() {
        UIManager.put("ProgressBarUI", MovementProgressBarUi.class.getName());
        UIManager.getDefaults().put(MovementProgressBarUi.class.getName(), MovementProgressBarUi.class);
    }
}
