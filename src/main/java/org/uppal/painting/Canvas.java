package org.uppal.painting;

import java.util.Set;

public class Canvas {
    private final int width, height, widthEdge, heightEdge;
    private final char VERTICAL_EDGE;
    private final char HORIZONTAL_EDGE;

    private final char character;

    private final char[][] canvas;

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
        canvas = initializeCanvas(widthEdge, heightEdge);
    }

    public void apply(Set<Coordinate> coordinates, char character) {
        for (Coordinate c : coordinates) {
            if (!isInBoundary(c)) {
                System.out.println("Coordinate " + c + " is not in the canvas defined");
                return;
            }
        }
        for (Coordinate c : coordinates) {
            canvas[c.getX()][c.getY()] = character;
        }
    }

    public void apply(Set<Coordinate> coordinates) {
        apply(coordinates, character);
    }

    public boolean isValidPixel(Coordinate coordinate) {
        if (isInBoundary(coordinate) && canvas[coordinate.getX()][coordinate.getY()] != character) return true;
        else return false;
    }

    public boolean isInBoundary(Coordinate coordinate) {
        int x = coordinate.getX();
        int y = coordinate.getY();
        if (x <= width && x >= 1 && y <= height && y >= 1) return true;
        else return false;
    }

    public int getWidthEdge() {
        return widthEdge;
    }

    public int getHeightEdge() {
        return heightEdge;
    }

    public char[][] getCanvas() {
        return canvas;
    }

    private char[][] initializeCanvas(int widthEdge, int heightEdge) {
        char[][] canvas = new char[widthEdge][heightEdge];
        for (int i = 0; i < widthEdge; i++) {
            for (int j = 0; j < heightEdge; j++) {
                if (i == 0 && j == 0 || (i == width + 1 && j == height + 1)) {
                    canvas[i][j] = HORIZONTAL_EDGE;
                } else if (i == 0 && j == heightEdge - 1) {
                    canvas[i][j] = HORIZONTAL_EDGE;
                } else if (i == 0 || j == 0) {
                    canvas[i][j] = i == 0 ? VERTICAL_EDGE : HORIZONTAL_EDGE;
                } else if (i == width + 1 || j == height + 1) {
                    canvas[i][j] = i == (width + 1) ? VERTICAL_EDGE : HORIZONTAL_EDGE;
                } else {
                    char EMPTY = ' ';
                    canvas[i][j] = EMPTY;
                }
            }
        }
        return canvas;
    }

}
