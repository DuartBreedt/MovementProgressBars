import com.intellij.openapi.ui.GraphicsConfig;
import com.intellij.openapi.util.ScalableIcon;
import com.intellij.ui.Gray;
import com.intellij.ui.JBColor;
import com.intellij.ui.scale.JBUIScale;
import com.intellij.util.ui.GraphicsUtil;
import com.intellij.util.ui.JBUI;
import com.intellij.util.ui.UIUtil;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicGraphicsUtils;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class MovementProgressBarUi extends BasicProgressBarUI {
    private static final float ONE_OVER_SEVEN = 1f / 7;
    private static final Color VIOLET = new JBColor(new Color(90, 0, 157), new Color(90, 0, 157));
    private static final int BAR_HEIGHT = 20;

    private volatile int offset = 0;
    private volatile int offset2 = 0;
    private volatile int velocity = 1;

    @SuppressWarnings({"UnusedDeclaration"})
    public static ComponentUI createUI(JComponent component) {
        component.setBorder(JBUI.Borders.empty().asUIResource());
        return new MovementProgressBarUi();
    }

    private static boolean isOdd(int value) {
        return value % 2 == 1;
    }

    @Override
    public Dimension getPreferredSize(JComponent c) {
        return new Dimension(super.getPreferredSize(c).width, JBUI.scale(BAR_HEIGHT));
    }

    @Override
    protected void installListeners() {
        super.installListeners();
        progressBar.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
            }

            @Override
            public void componentHidden(ComponentEvent e) {
                super.componentHidden(e);
            }
        });
    }

    @Override
    protected void paintIndeterminate(Graphics graphics, JComponent component) {
        if (!(graphics instanceof Graphics2D)) {
            return;
        }

        Graphics2D graphics2D = (Graphics2D) graphics;

        Insets borderInsets = progressBar.getInsets(); // area for border
        int barRectWidth = progressBar.getWidth() - (borderInsets.right + borderInsets.left);
        int barRectHeight = progressBar.getHeight() - (borderInsets.top + borderInsets.bottom);

        if (barRectWidth <= 0 || barRectHeight <= 0) {
            return;
        }

        graphics2D.setColor(new JBColor(Gray._240.withAlpha(50), Gray._128.withAlpha(50)));
        int width = component.getWidth();
        int height = component.getPreferredSize().height;
        if (isOdd(component.getHeight() - height)) height++;

        LinearGradientPaint baseRainbowPaint = createFlagPaint(height);

        graphics2D.setPaint(baseRainbowPaint);

        if (component.isOpaque()) {
            graphics2D.fillRect(0, (component.getHeight() - height) / 2, width, height);
        }

        graphics2D.setColor(new JBColor(Gray._165.withAlpha(50), Gray._88.withAlpha(50)));

        final GraphicsConfig config = GraphicsUtil.setupAAPainting(graphics2D);

        graphics2D.translate(0, (component.getHeight() - height) / 2);

        Paint old = graphics2D.getPaint();
        graphics2D.setPaint(baseRainbowPaint);

        final float R = JBUIScale.scale(8f);
        final float R2 = JBUIScale.scale(9f);
        final Area containingRoundRect = new Area(new RoundRectangle2D.Float(1f, 1f, width - 2f, height - 2f, R, R));

        graphics2D.fill(containingRoundRect);

        graphics2D.setPaint(old);
        offset = (offset + 1) % getPeriodLength();
        offset2 += velocity;
        if (offset2 <= 2) {
            offset2 = 2;
            velocity = 1;
        } else if (offset2 >= width - JBUI.scale(15)) {
            offset2 = width - JBUI.scale(15);
            velocity = -1;
        }

        Area area = new Area(new Rectangle2D.Float(0, 0, width, height));
        area.subtract(new Area(new RoundRectangle2D.Float(1f, 1f, width - 2f, height - 2f, R, R)));
        graphics2D.setPaint(Gray._128);
        if (component.isOpaque()) {
            graphics2D.fill(area);
        }

        area.subtract(new Area(new RoundRectangle2D.Float(0, 0, width, height, R2, R2)));

        Container parent = component.getParent();
        Color background = parent != null ? parent.getBackground() : UIUtil.getPanelBackground();
        graphics2D.setPaint(background);
        if (component.isOpaque()) {
            graphics2D.fill(area);
        }

        Icon scaledIcon = velocity > 0 ? ((ScalableIcon) MovementIcons.CAT_ICON) : ((ScalableIcon) MovementIcons.RCAT_ICON);
        scaledIcon.paintIcon(progressBar, graphics2D, offset2 - JBUI.scale(10), -JBUI.scale(6));

        graphics2D.draw(new RoundRectangle2D.Float(1f, 1f, width - 2f - 1f, height - 2f - 1f, R, R));
        graphics2D.translate(0, -(component.getHeight() - height) / 2);

        // Deal with possible text painting
        if (progressBar.isStringPainted()) {
            if (progressBar.getOrientation() == SwingConstants.HORIZONTAL) {
                paintString(graphics2D, borderInsets.left, borderInsets.top, barRectWidth, barRectHeight, boxRect.x, boxRect.width);
            } else {
                paintString(graphics2D, borderInsets.left, borderInsets.top, barRectWidth, barRectHeight, boxRect.y, boxRect.height);
            }
        }
        config.restore();
    }

    @Override
    protected void paintDeterminate(Graphics g, JComponent c) {
        if (!(g instanceof Graphics2D)) {
            return;
        }

        if (progressBar.getOrientation() != SwingConstants.HORIZONTAL || !c.getComponentOrientation().isLeftToRight()) {
            super.paintDeterminate(g, c);
            return;
        }
        final GraphicsConfig config = GraphicsUtil.setupAAPainting(g);
        Insets b = progressBar.getInsets(); // area for border
        int w = progressBar.getWidth();
        int h = progressBar.getPreferredSize().height;
        if (isOdd(c.getHeight() - h)) h++;

        int barRectWidth = w - (b.right + b.left);
        int barRectHeight = h - (b.top + b.bottom);

        if (barRectWidth <= 0 || barRectHeight <= 0) {
            return;
        }

        int amountFull = getAmountFull(b, barRectWidth, barRectHeight);

        Container parent = c.getParent();
        Color background = parent != null ? parent.getBackground() : UIUtil.getPanelBackground();

        g.setColor(background);
        Graphics2D g2 = (Graphics2D) g;
        if (c.isOpaque()) {
            g.fillRect(0, 0, w, h);
        }

        final float R = JBUIScale.scale(8f);
        final float R2 = JBUIScale.scale(9f);
        final float off = JBUIScale.scale(1f);

        g2.translate(0, (c.getHeight() - h) / 2);
        g2.setColor(progressBar.getForeground());
        g2.fill(new RoundRectangle2D.Float(0, 0, w - off, h - off, R2, R2));
        g2.setColor(background);
        g2.fill(new RoundRectangle2D.Float(off, off, w - 2f * off - off, h - 2f * off - off, R, R));
        g2.setPaint(createFlagPaint(h));

        MovementIcons.CAT_ICON.paintIcon(progressBar, g2, amountFull - JBUI.scale(10), -JBUI.scale(6));
        g2.fill(new RoundRectangle2D.Float(2f * off, 2f * off, amountFull - JBUIScale.scale(5f), h - JBUIScale.scale(5f), JBUIScale.scale(7f), JBUIScale.scale(7f)));
        g2.translate(0, -(c.getHeight() - h) / 2);

        // Deal with possible text painting
        if (progressBar.isStringPainted()) {
            paintString(g, b.left, b.top, barRectWidth, barRectHeight, amountFull, b);
        }
        config.restore();
    }

    private void paintString(Graphics g, int x, int y, int w, int h, int fillStart, int amountFull) {
        if (!(g instanceof Graphics2D)) {
            return;
        }

        Graphics2D g2 = (Graphics2D) g;
        String progressString = progressBar.getString();
        g2.setFont(progressBar.getFont());
        Point renderLocation = getStringPlacement(g2, progressString, x, y, w, h);
        Rectangle oldClip = g2.getClipBounds();

        if (progressBar.getOrientation() == SwingConstants.HORIZONTAL) {
            g2.setColor(getSelectionBackground());
            BasicGraphicsUtils.drawString(progressBar, g2, progressString, renderLocation.x, renderLocation.y);
            g2.setColor(getSelectionForeground());
            g2.clipRect(fillStart, y, amountFull, h);
            BasicGraphicsUtils.drawString(progressBar, g2, progressString, renderLocation.x, renderLocation.y);
        } else { // VERTICAL
            g2.setColor(getSelectionBackground());
            AffineTransform rotate = AffineTransform.getRotateInstance(Math.PI / 2);
            g2.setFont(progressBar.getFont().deriveFont(rotate));
            renderLocation = getStringPlacement(g2, progressString, x, y, w, h);
            BasicGraphicsUtils.drawString(progressBar, g2, progressString, renderLocation.x, renderLocation.y);
            g2.setColor(getSelectionForeground());
            g2.clipRect(x, fillStart, w, amountFull);
            BasicGraphicsUtils.drawString(progressBar, g2, progressString, renderLocation.x, renderLocation.y);
        }
        g2.setClip(oldClip);
    }

    @Override
    protected int getBoxLength(int availableLength, int otherDimension) {
        return availableLength;
    }

    private LinearGradientPaint createFlagPaint(int height) {
        return new LinearGradientPaint(0, JBUI.scale(2), 0, height - JBUI.scale(6),
                new float[]{ONE_OVER_SEVEN * 1, ONE_OVER_SEVEN * 2, ONE_OVER_SEVEN * 3, ONE_OVER_SEVEN * 4, ONE_OVER_SEVEN * 5, ONE_OVER_SEVEN * 6, ONE_OVER_SEVEN * 7},
                new Color[]{JBColor.RED, JBColor.ORANGE, JBColor.YELLOW, JBColor.GREEN, JBColor.CYAN, JBColor.BLUE, VIOLET});
    }

    private int getPeriodLength() {
        return JBUI.scale(16);
    }
}

