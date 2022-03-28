package org.uppal.painting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.uppal.painting.TestingUtil.*;
import static org.uppal.painting.TestingUtil.parseCsvInput;

public class RectangleTest {

    @ParameterizedTest
    @CsvSource({"1-1;5-5|1-1;2-1;3-1;4-1;5-1;5-2;5-3;5-4;5-5;4-5;3-5;2-5;1-5;1-4;1-3;1-2", "1-1;2-2|1-1;1-2;2-2;2-1"})
    void WHEN_rectangle_painted_THEN_rectangle_with_correct_coordinates_returned(String text) {
        String[] splitLine = text.split(DELIMITER_INPUT_OUTPUT);
        List<Coordinate> input = parseCsvInput(splitLine[0]);
        assertThat(input.size()).isEqualTo(2);
        Set<Coordinate> expectedOutput = new HashSet<>(parseCsvInput(splitLine[1]));
        Painter rectangle = new Rectangle(input.get(0), input.get(1));
        Set<Coordinate> actualOutput = rectangle.paint();
        assertThat(actualOutput).isEqualTo(expectedOutput);
    }
}
