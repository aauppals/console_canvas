package org.uppal.commandexecution;

import org.uppal.inputcommand.*;
import org.uppal.painting.*;

import java.util.Map;

public class CommandExecutor {
    private static final CommandParser commandParser = new CommandParser();

    private Painter painter;

    public String execute(String inputCommand) {
        try {
            Map<PaintingParams, Object> parsedCommand = commandParser.parse(inputCommand);
            Command command = (Command) parsedCommand.get(PaintingParams.PAINT_COMMAND);
            Object object;
            LineAndRectangleBuilder lineAndRectangleBuilder = new LineAndRectangleBuilder();
            CanvasBuilder canvasBuilder = new CanvasBuilder();
            FillBuilder fillBuilder = new FillBuilder();

            switch (command) {
                case CANVAS:
                    object = canvasBuilder.build(parsedCommand);
                    Canvas canvas = (Canvas) object;
                    painter = new CanvasPainter(canvas);
                    return displayString(canvas);

                case LINE:
                    object = lineAndRectangleBuilder.build(parsedCommand);
                    return displayString(painter.paint((Paintable) object));
                case RECTANGLE:
                    LineAndRectangleBuilder lineAndRectangleBuilder1 = new LineAndRectangleBuilder();
                    object = lineAndRectangleBuilder1.build(parsedCommand);
                    return displayString(painter.paint((Paintable) object));

                case FILL:
                    object = fillBuilder.build(parsedCommand);
                    return displayString(painter.paint((Fill) object));

                default:
                    throw new RuntimeException("A Canvas should be made before painting!");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error occurred during parsing command " + inputCommand + "\n" + e);
        }
    }

    private static String displayString(Canvas canvas) {
        StringBuilder result = new StringBuilder();
        int heightEdge = canvas.getHeightEdge();
        int widthEdge = canvas.getWidthEdge();
        char[][] characters = canvas.getCanvas();
        for (int i = 0; i < heightEdge; i++) {
            for (int j = 0; j < widthEdge; j++) {
                if (j == widthEdge - 1) {
                    result.append(characters[j][i]).append('\n');
                } else {
                    result.append(characters[j][i]);
                }
            }
        }
        return result.toString();
    }
}
