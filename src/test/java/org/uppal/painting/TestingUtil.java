package org.uppal.painting;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class TestingUtil {
    static final String DELIMITER_INPUT_OUTPUT = "\\|";

    static List<Coordinate> parseCsvInput(String text) {
        String[] splitCoords = text.split(";");

        List<Coordinate> result = new ArrayList<>();
        for (String coord : splitCoords) {
            String[] nums = coord.split("-");
            result.add(new Coordinate(parseInt(nums[0]), parseInt(nums[1])));
        }

        return result;
    }
}
