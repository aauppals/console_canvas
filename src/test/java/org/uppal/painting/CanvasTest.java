package org.uppal.painting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static java.lang.Integer.parseInt;
import static org.assertj.core.api.Assertions.assertThat;

public class CanvasTest {

    private static final char horizontal_edge = '-';
    private static final char vertical_edge = '|';

    @ParameterizedTest
    @CsvSource({"20:4", "30:50", "100:100"})
     void WHEN_canvas_is_created_then_canvas_with_correct_size_and_characters_returned(String inputCommand) {
        String[] split = inputCommand.split(":");
        int width = parseInt(split[0]);
        int height = parseInt(split[1]);
        Canvas canvas = new Canvas(width, height, 'x', '|', '-');
        verifyCanvas(canvas.getCanvas(), width, height);
    }

    private void verifyCanvas(char[][] canvas, int width, int height) {
        for (int i = 0; i < width; i++) {
            assertThat(canvas[i][0]).isEqualTo(horizontal_edge);
        }
        for (int j = 1; j < height; j++) {
            assertThat(canvas[0][j]).isEqualTo(vertical_edge);
        }
    }
}
