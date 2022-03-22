package org.uppal.commandExecution;

import org.uppal.inputCommand.Command;
import org.uppal.inputCommand.CommandParser;
import org.uppal.inputCommand.PaintingParams;
import org.uppal.painting.*;

import java.util.Map;

public class CommandExecutor {
    private static final CommandParser commandParser = new CommandParser();

    private Canvas canvas;
    private Drawer drawer;

    public String execute(String inputCommand) {
        try {
            Map<PaintingParams, Object> parsedCommand = commandParser.parse(inputCommand);
            Command command = (Command) parsedCommand.get(PaintingParams.PAINT_COMMAND);
            Object object = null;
            LineAndRectangleBuilder lineAndRectangleBuilder = new LineAndRectangleBuilder();
            CanvasBuilder canvasBuilder = new CanvasBuilder();
            FillBuilder fillBuilder = new FillBuilder();

            switch (command) {
                case CANVAS:
                    object = canvasBuilder.build(parsedCommand);
                    canvas = (Canvas) object;
                    drawer = new CanvasDrawer(canvas);
                    return displayString(canvas);

                case LINE:

                case RECTANGLE:
                    object = lineAndRectangleBuilder.build(parsedCommand);
                    return displayString(drawer.draw((Drawable) object));

                case FILL:
                    object = fillBuilder.build(parsedCommand);
                    return displayString(drawer.draw((Fill) object));

                default:
                    throw new RuntimeException("Drawer is null - a canvas is to be made before painting!");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error occured during parsing command " + inputCommand + "\n" + e);
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
