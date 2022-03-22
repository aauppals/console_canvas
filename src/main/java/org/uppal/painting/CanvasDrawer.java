package org.uppal.painting;

import java.util.Set;

import static java.util.Objects.requireNonNull;

public class CanvasDrawer implements Drawer {
    private Canvas canvas;

    public CanvasDrawer(Canvas canvas) {
        this.canvas = requireNonNull(canvas);
    }

    @Override
    public Canvas draw(Drawable drawable) {
        Set<Coordinate> coordinates = drawable.draw();
        canvas.apply(coordinates);
        return canvas;
    }

    @Override
    public Canvas draw(Fill fill) {
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
