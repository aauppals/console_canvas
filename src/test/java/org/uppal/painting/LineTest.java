package org.uppal.painting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.uppal.painting.TestingUtil.*;

public class LineTest {

    @ParameterizedTest
    @CsvSource({"1-5;4-5|1-5;2-5;3-5;4-5", "1-1;5-1|1-1;2-1;3-1;4-1;5-1", "1-1;1-1|1-1"})
    void drawTest(String text) {
        String[] splitLine = text.split(DELIMITER_INPUT_OUTPUT);
        List<Coordinate> input = parseCsvInput(splitLine[0]);
        assertThat(input.size()).isEqualTo(2);
        Set<Coordinate> expectedOutput = new HashSet<>(parseCsvInput(splitLine[1]));
        Paintable line = new Line(input.get(0), input.get(1));
        Set<Coordinate> actualOutput = line.paint();
        assertThat(actualOutput).isEqualTo(expectedOutput);
    }
}
