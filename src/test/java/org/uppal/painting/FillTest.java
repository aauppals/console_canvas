package org.uppal.painting;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class FillTest {
    private static final char COLOR = 'o';
    private static final int WIDTH = 2;
    private static final int HEIGHT = 2;
    private static final char VERTICAL_EDGE = '|';
    private static final char HORIZONTAL_EDGE = '-';
    public static final char CHAR = 'x';
    private static Canvas emptyCanvas;
    private static Canvas testCanvas;

    @BeforeAll
    public static void initializeCanvases() {
        emptyCanvas = new Canvas(WIDTH, HEIGHT, CHAR, VERTICAL_EDGE, HORIZONTAL_EDGE);
        testCanvas = new Canvas(WIDTH, HEIGHT, CHAR, VERTICAL_EDGE, HORIZONTAL_EDGE);
    }

    @Test
    public void WHEN_fill_is_done_THEN_canvas_with_correct_fill_returned() {
        Fill canvasFill = new Fill(new Coordinate(1, 1), COLOR);

        Set<Coordinate> actualOutput = canvasFill.fill(emptyCanvas);
        Set<Coordinate> expectedOutput = getFillCoordinatesForEmptyCanvas();
        assertThat(actualOutput).isEqualTo(expectedOutput);

        actualOutput = canvasFill.fill(testCanvas);
        expectedOutput.clear();
        expectedOutput.add(new Coordinate(1, 1));
        expectedOutput.add(new Coordinate(1, 2));
        expectedOutput.add(new Coordinate(2, 1));
        expectedOutput.add(new Coordinate(2, 2));
        assertThat(actualOutput).isEqualTo(expectedOutput);
    }

    private Set<Coordinate> getFillCoordinatesForEmptyCanvas() {
        Set<Coordinate> expectedOutput = new HashSet<>();
        for (int w = 1; w <= WIDTH; w++) {
            for (int h = 1; h <= HEIGHT; h++) {
                expectedOutput.add(new Coordinate(w, h));
            }
        }
        return expectedOutput;
    }

}
