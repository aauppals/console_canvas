package org.uppal.painting;

import java.util.Set;

import static java.util.Objects.requireNonNull;

public class CanvasPainter implements Painter {
    private Canvas canvas;

    public CanvasPainter(Canvas canvas) {
        this.canvas = requireNonNull(canvas);
    }

    @Override
    public Canvas paint(Paintable paintable) {
        Set<Coordinate> coordinates = paintable.paint();
        canvas.apply(coordinates);
        return canvas;
    }

    @Override
    public Canvas paint(Fill fill) {
        Set<Coordinate> coordinates = fill.fill(canvas);
        canvas.apply(coordinates, fill.getColour());
        return canvas;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }
}
