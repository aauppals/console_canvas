package org.uppal.painting;

import java.util.HashSet;
import java.util.Set;

import static java.util.Objects.requireNonNull;

public class Fill {
    private final Coordinate coordinate;
    private final char colour;

    public Fill(Coordinate coordinate, char colour) {
        this.coordinate = requireNonNull(coordinate);
        this.colour = colour;
    }

    public char getColour() {
        return colour;
    }

    public Set<Coordinate> fill(Canvas canvas) {
        Set<Coordinate> coordinates = new HashSet<>();
        executeFill(coordinate, coordinates, canvas);
        if (coordinates.isEmpty()) {
            System.out.println("Cannot fill at co-ordinates" + coordinate);
        }
        return coordinates;
    }

    public void executeFill(Coordinate coordinate, Set<Coordinate> coordinates, Canvas canvas) {
        if (!canvas.isValidPixel(coordinate) || !canvas.isInBoundary(coordinate) || coordinates.contains(coordinate)) {
            return;
        }
        coordinates.add(coordinate);
        executeFill(new Coordinate(coordinate.getX(), coordinate.getY() + 1), coordinates, canvas);
        executeFill(new Coordinate(coordinate.getX() + 1, coordinate.getY()), coordinates, canvas);
        executeFill(new Coordinate(coordinate.getX(), coordinate.getY() - 1), coordinates, canvas);
        executeFill(new Coordinate(coordinate.getX() - 1, coordinate.getY()), coordinates, canvas);
    }
}
