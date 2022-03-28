package org.uppal.painting;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CanvasPainterImplTest {
    public static final char CHAR = 'x';
    private static final int WIDTH = 20;
    private static final int HEIGHT = 4;
    private final Canvas canvas = new Canvas(WIDTH, HEIGHT, CHAR, '|', '-');
    private final CanvasPainter canvasPainter = new CanvasPainterImpl(canvas);

    @Test
    void WHEN_line_is_painted_THEN_canvas_with_correct_line_returned() {
        Painter line = new Line(new Coordinate(1, 2), new Coordinate(6, 2));
        Canvas actualCanvas = canvasPainter.paint(line);
        char[][] board = actualCanvas.getCanvas();
        for (int i = 1; i <= 6; i++) {
            assertThat(board[i][2]).isEqualTo(CHAR);
        }
    }

    @Test
    void WHEN_rectangle_is_painted_THEN_canvas_with_correct_rectangle_returned() {
        Painter rectangle = new Rectangle(new Coordinate(14, 1), new Coordinate(18, 3));
        Canvas actualCanvas = canvasPainter.paint(rectangle);
        char[][] board = actualCanvas.getCanvas();
        //bottom line
        for (int i = 14; i <= 18; i++) {
            assertThat(board[i][3]).isEqualTo(CHAR);
        }
        //right vertical line
        for (int i = 1; i <= 3; i++) {
            assertThat(board[18][i]).isEqualTo(CHAR);
        }
        //top line
        for (int i = 14; i <= 18; i++) {
            assertThat(board[i][1]).isEqualTo(CHAR);
        }
        //left vertical line
        for (int i = 1; i <= 3; i++) {
            assertThat(board[14][i]).isEqualTo(CHAR);
        }
    }

    @Test
    void WHEN_fill_is_used_THEN_canvas_with_correct_fill_returned() {
        char colour = '^';
        Fill fill = new Fill(new Coordinate(1, 1), colour);
        Canvas actualCanvas = canvasPainter.paint(fill);
        char[][] board = actualCanvas.getCanvas();
        for (int i = 1; i <= WIDTH; i++) {
            for (int j = 1; j <= HEIGHT; j++) {
                assertThat(board[i][j]).isEqualTo(colour);
            }
        }
    }

}
