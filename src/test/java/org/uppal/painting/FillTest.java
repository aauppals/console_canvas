package org.uppal.painting;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FillTest {
    private static final char COLOR = 'o';
    private static final int WIDTH = 2;
    private static final int HEIGHT = 2;
    private static final char VERTICAL_EDGE = '|';
    private static final char HORIZONTAL_EDGE = '-';
    public static final char CHAR = 'x';
    private static Canvas emptyCanvas;
    private static Canvas testCanvas;
    private static Canvas fullCanvas;

    @BeforeAll
    public static void initializeCanvases() {
        fullCanvas = mock(Canvas.class);
        emptyCanvas = new Canvas(WIDTH, HEIGHT, CHAR, VERTICAL_EDGE, HORIZONTAL_EDGE);
        testCanvas = new Canvas(WIDTH, HEIGHT, CHAR, VERTICAL_EDGE, HORIZONTAL_EDGE);
    }

    @Test
    public void when_fill_is_done_then_canvas_with_correct_fill_returned() {
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

    @Test
    public void fullCanvasTest() {
        when(fullCanvas.isValidPixel(isNull())).thenReturn(false);
        Fill bucketFill = new Fill(new Coordinate(6, 6), COLOR);
        assertThat(bucketFill.fill(fullCanvas)).isEmpty();
    }
}
