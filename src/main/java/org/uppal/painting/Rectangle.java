package org.uppal.painting;

import com.google.common.collect.ImmutableSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Objects.requireNonNull;

class Rectangle implements Paintable {
    private final Set<Paintable> lines;

    Rectangle(Coordinate topLeft, Coordinate bottomRight) {
        String msgForNullCoordinate = " coordinate cannot be null";
        requireNonNull(topLeft, "Top left" + msgForNullCoordinate);
        requireNonNull(topLeft, "bottomRight" + msgForNullCoordinate);

        if (isTopLeft(topLeft, bottomRight)) {
            lines = toLines(topLeft, bottomRight);
        } else {
            throw new IllegalArgumentException("Top left coordinate is not at the top left of bottom Right coordinate");
        }
    }

    public static boolean isTopLeft(Coordinate topLeft, Coordinate bottomRight) {
        return topLeft.getX() < bottomRight.getX() && topLeft.getY() < bottomRight.getY();
    }

    @Override
    public Set<Coordinate> paint() {
        Set<Coordinate> resultSet = new HashSet<>();
        for (Paintable line : lines) {
            resultSet.addAll(line.paint());
        }
        return ImmutableSet.copyOf(resultSet);
    }

    private Set<Paintable> toLines(Coordinate topLeft, Coordinate bottomRight) {
        List<Paintable> lines = new ArrayList<>();
        lines.add(new Line(topLeft, new Coordinate(bottomRight.getX(), topLeft.getY())));
        lines.add(new Line(bottomRight, new Coordinate(topLeft.getX(), bottomRight.getY())));
        lines.add(new Line(topLeft, new Coordinate(topLeft.getX(), bottomRight.getY())));
        lines.add(new Line(bottomRight, new Coordinate(bottomRight.getX(), topLeft.getY())));
        return ImmutableSet.copyOf(lines);
    }
}

