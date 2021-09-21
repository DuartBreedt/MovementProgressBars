package com.duartbreedt.movementprogressbars;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.ui.GraphicsConfig;
import com.intellij.ui.scale.JBUIScale;
import com.intellij.util.ui.GraphicsUtil;
import com.intellij.util.ui.JBUI;
import org.jetbrains.annotations.Contract;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;
import java.lang.reflect.Constructor;
import java.nio.FloatBuffer;
import java.util.LinkedList;

public class MovementProgressBarUi extends BasicProgressBarUI {

    private static final int BAR_HEIGHT = 20;
    private static final int STROKE_WIDTH = 1;
    private static final int BORDER_RADIUS = 9;

    private static final float uiStrokeWidth = JBUIScale.scale(STROKE_WIDTH);
    private static final float uiComponentCornerRadius = JBUIScale.scale(BORDER_RADIUS);
    private static final float uiInnerLoaderCornerRadius = uiComponentCornerRadius - (uiStrokeWidth * 2);

    private static final int progressIncrements = 1;
    private int indeterminateProgress = 0;

    private Color[] colors;
    private float colorFraction;

    @Contract("_ -> new")
    @SuppressWarnings({"UnusedDeclaration"})
    public static ComponentUI createUI(JComponent component) {
        component.setBorder(JBUI.Borders.empty().asUIResource());
        return new MovementProgressBarUi();
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
        paintFlag(graphics, component, indeterminateProgress);
        indeterminateProgress += progressIncrements;
    }

    @Override
    protected void paintDeterminate(Graphics graphics, JComponent component) {
        int componentWidth = progressBar.getWidth();
        int componentHeight = progressBar.getPreferredSize().height;
        int progress = getAmountFull(progressBar.getInsets(), componentWidth, componentHeight);
        paintFlag(graphics, component, progress);
    }

    private void paintFlag(Graphics graphics, JComponent component, int progress) {
        if (progressBar.getOrientation() != SwingConstants.HORIZONTAL || !component.getComponentOrientation().isLeftToRight()) {

            // TODO: Potential future work for vertical progress bars

            super.paintDeterminate(graphics, component);
            return;
        }

        if (!(graphics instanceof Graphics2D)) {
            return;
        }

        // TODO Extract
        if (colors == null || colors.length == 0) {
            String enumValue = PropertiesComponent.getInstance().getValue(FlagColor.PROPERTY_KEY);
            FlagColor flagColor;
            try {
                Class<?> clazz = Class.forName(enumValue);
                Constructor<?> ctor = clazz.getConstructor();
                flagColor = (FlagColor) ctor.newInstance();
            } catch (Exception e) {
                // Swallow
                flagColor = new ClassicPride();
            }

            colors = flagColor.getColors();
            colorFraction = 1f / colors.length;
        }

        int componentWidth = progressBar.getWidth();
        int componentHeight = progressBar.getPreferredSize().height;
        float flagHeight = componentHeight - (uiStrokeWidth * 2);
        Graphics2D graphics2D = (Graphics2D) graphics;
        final GraphicsConfig config = GraphicsUtil.setupAAPainting(graphics2D);

        progressBar.setBorder(JBUI.Borders.empty((int) uiStrokeWidth));
        progressBar.setBorderPainted(false);

        Shape innerLoaderShape = new RoundRectangle2D.Float(0 + uiStrokeWidth, 0 + uiStrokeWidth, progress, flagHeight, uiInnerLoaderCornerRadius, uiInnerLoaderCornerRadius);
        Shape strokeShape = new RoundRectangle2D.Float(0, 0, componentWidth - uiStrokeWidth, componentHeight - uiStrokeWidth, uiComponentCornerRadius, uiComponentCornerRadius);

        try {
            graphics2D.setPaint(createFlagPaint(colors, (int) flagHeight));
        } catch (Exception e) {
            // Swallow
        }
        graphics2D.fill(innerLoaderShape);
        graphics2D.setColor(progressBar.getForeground());
        graphics2D.draw(strokeShape);
        graphics2D.setStroke(new BasicStroke(uiStrokeWidth));

        // TODO: Paint flag at the end of the progress bar using paintString, isStringPainted, etc and make it toggleable

        config.restore();
    }

    @Override
    protected int getBoxLength(int availableLength, int otherDimension) {
        return availableLength;
    }

    private LinearGradientPaint createFlagPaint(Color[] colors, int height) {
        float fadeFactor = 0.01f;

        LinkedList<Float> fractionsList = new LinkedList<>();
        LinkedList<Color> colorsList = new LinkedList<>();

        for (int i = 0; i < colors.length; i++) {
            if (i == 0) { // First item
                fractionsList.add(colorFraction * i);
                fractionsList.add(colorFraction * (i + 1) - fadeFactor);
            } else if (i == colors.length - 1) { // Last item
                fractionsList.add(colorFraction * i + fadeFactor);
                fractionsList.add(colorFraction * (i + 1));
            } else { // Middle item(s)
                fractionsList.add(colorFraction * i + fadeFactor);
                fractionsList.add(colorFraction * (i + 1) - fadeFactor);
            }
            colorsList.add(colors[i]);
            colorsList.add(colors[i]);
        }

        float[] fractions = fractionsList.stream().collect(
                () -> FloatBuffer.allocate(fractionsList.size()),
                FloatBuffer::put,
                (left, right) -> {
                    throw new UnsupportedOperationException("Can only be called in parallel stream");
                }).array();
        Color[] colorArray = colorsList.toArray(new Color[0]);
        return new LinearGradientPaint(0, 0, 0, height, fractions, colorArray);
    }
}

