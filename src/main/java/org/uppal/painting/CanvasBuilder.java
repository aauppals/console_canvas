package org.uppal.painting;

import org.uppal.inputCommand.PaintingParams;

import java.util.Map;

import static org.uppal.inputCommand.PaintingParams.HEIGHT;
import static org.uppal.inputCommand.PaintingParams.WIDTH;

public class CanvasBuilder {
    private static final char CHARACTER = 'x';
    private static final char HORIZONTAL_EDGE = '-';
    private static final char VERTICAL_EDGE = '|';

    public Canvas build(Map<PaintingParams, Object> parsedCommand) {
        return new Canvas((Integer) parsedCommand.get(WIDTH), (Integer) parsedCommand.get(HEIGHT),
                CHARACTER, VERTICAL_EDGE, HORIZONTAL_EDGE);
    }
}