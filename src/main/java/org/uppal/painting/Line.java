package org.uppal.painting;

import com.google.common.collect.ImmutableSet;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static java.lang.Math.min;
import static java.lang.StrictMath.abs;
import static java.util.Objects.requireNonNull;

public class Line implements Painter {
    private final Coordinate coordinate1;
    private final Coordinate coordinate2;

    Line(Coordinate coordinate1, Coordinate coordinate2) {
        this.coordinate1 = requireNonNull(coordinate1);
        this.coordinate2 = requireNonNull(coordinate2);
        checkVerticalOrHorizontal(coordinate1, coordinate2);
    }

    @Override
    public Set<Coordinate> paint() {
        Set<Coordinate> resultSet = new HashSet<>();
        boolean xIsSame = coordinate1.getX() == coordinate2.getX();
        if (xIsSame) {
            int x = coordinate1.getX();
            int minY = min(coordinate1.getY(), coordinate2.getY());
            int distance = abs(coordinate1.getY() - coordinate2.getY());
            for (int i = 0; i <= distance; i++) {
                resultSet.add(new Coordinate(x, minY + i));
            }
        } else {
            int y = coordinate1.getY();
            int minX = min(coordinate1.getX(), coordinate2.getX());
            int distance = StrictMath.abs(coordinate1.getX() - coordinate2.getX());
            for (int i = 0; i <= distance; i++) {
                resultSet.add(new Coordinate(minX + i, y));
            }
        }
        return ImmutableSet.copyOf(resultSet);
    }

    private void checkVerticalOrHorizontal(Coordinate coordinate1, Coordinate coordinate2) {
        if (!(coordinate1.getX() == coordinate2.getX() || coordinate1.getY() == coordinate2.getY()))
            throw new RuntimeException("Only horizontal and vertical line painting is supported currently");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return coordinate1.equals(line.coordinate1) && Objects.equals(coordinate2, line.coordinate2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate1, coordinate2);
    }
}
