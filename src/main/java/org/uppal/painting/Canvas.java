package org.uppal.painting;

import java.util.Set;

public class Canvas {
    private final int width, height, widthEdge, heightEdge;
    private final char VERTICAL_EDGE;
    private final char HORIZONTAL_EDGE;

    private final char EMPTY = ' ';
    private final char character;

    private char[][] canvas;

    public Canvas(int width, int height, char character, char verticalEdge, char horizontalEdge) {
        if (width < 1 || height < 1) {
            throw new IllegalArgumentException("Canvas height and width cannot be less than 1");
        }

        this.width = width;
        this.height = height;
        this.VERTICAL_EDGE = verticalEdge;
        this.HORIZONTAL_EDGE = horizontalEdge;
        this.character = character;

        widthEdge = width + 2;
        heightEdge = height + 2;
    }

    public void apply(Set<Coordinate> coordinates, char character) {
        for (Coordinate c : coordinates) {
            if (!isInCanvas(c)) {
                System.out.println("Coordinate " + c + " is not in the canvas defined");
                return;
            }
        }
        coordinates.forEach(c -> canvas[c.getX()][c.getY()] = character);
    }

    public void apply(Set<Coordinate> coordinates) {//CONTINUE FROM HERE!

    }
}
