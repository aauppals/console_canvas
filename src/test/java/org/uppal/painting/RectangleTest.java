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
    @CsvSource({"1-1;4-4|1-1;2-1;3-1;4-1;4-2;4-3;4-4;3-4;2-4;1-4;1-3;1-2", "1-1;2-2|1-1;1-2;2-2;2-1"})
    void drawTest(String text) {
        String[] splitLine = text.split(DELIMITER_INPUT_OUTPUT);
        List<Coordinate> input = parseCsvInput(splitLine[0]);
        assertThat(input.size()).isEqualTo(2);
        Set<Coordinate> expectedOutput = new HashSet<>(parseCsvInput(splitLine[1]));
        Paintable rectangle = new Rectangle(input.get(0), input.get(1));
        Set<Coordinate> actualOutput = rectangle.paint();
        assertThat(actualOutput).isEqualTo(expectedOutput);
    }
}
