package org.uppal.painting;

import java.util.Set;

import static java.util.Objects.requireNonNull;

public class CanvasPainterImpl implements CanvasPainter {
    private Canvas canvas;

    public CanvasPainterImpl(Canvas canvas) {
        this.canvas = requireNonNull(canvas);
    }

    @Override
    public Canvas paint(Painter painter) {
        Set<Coordinate> coordinates = painter.paint();
        canvas.apply(coordinates);
        return canvas;
    }

    @Override
    public Canvas paint(Fill fill) {
        Set<Coordinate> coordinates = fill.fill(canvas);
        canvas.apply(coordinates, fill.getColour());
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public Canvas getCanvas() {
        return canvas;
    }
}
