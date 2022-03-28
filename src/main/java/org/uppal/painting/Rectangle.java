package org.uppal.painting;

import com.google.common.collect.ImmutableSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Objects.requireNonNull;

class Rectangle implements Painter {
    private final Set<Painter> lines;

    Rectangle(Coordinate bottomLeft, Coordinate topRight) {
        String nullCoordinateMsg = " coordinate cannot be null";
        requireNonNull(bottomLeft, "Top left" + nullCoordinateMsg);
        requireNonNull(bottomLeft, "topRight" + nullCoordinateMsg);

        if (validateTopRight(bottomLeft, topRight)) {
            lines = toLines(bottomLeft, topRight);
        } else {
            throw new IllegalArgumentException("Top right coordinate is not at the top right of bottom left coordinate");
        }
    }

    public static boolean validateTopRight(Coordinate bottomLeft, Coordinate topRight) {
        if (bottomLeft.getX() < topRight.getX()) {
            if (bottomLeft.getY() < topRight.getY()) return true;
        }
        return false;
    }

    @Override
    public Set<Coordinate> paint() {
        Set<Coordinate> resultSet = new HashSet<>();
        for (Painter line : lines) {
            resultSet.addAll(line.paint());
        }
        return ImmutableSet.copyOf(resultSet);
    }

    private Set<Painter> toLines(Coordinate bottomLeft, Coordinate topRight) {
        List<Painter> lines = new ArrayList<>();
        lines.add(new Line(bottomLeft, new Coordinate(topRight.getX(), bottomLeft.getY())));
        lines.add(new Line(topRight, new Coordinate(bottomLeft.getX(), topRight.getY())));
        lines.add(new Line(bottomLeft, new Coordinate(bottomLeft.getX(), topRight.getY())));
        lines.add(new Line(topRight, new Coordinate(topRight.getX(), bottomLeft.getY())));
        return ImmutableSet.copyOf(lines);
    }
}

