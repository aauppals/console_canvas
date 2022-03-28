package org.uppal.inputcommand;

import java.util.EnumMap;


import static java.lang.Integer.parseInt;
import static org.uppal.inputcommand.Command.*;

public class CommandParser {
    private static final String DELIMITER = "\\s+";

    public EnumMap<PaintingParams, Object> parse(final String commandArgument) {
        String inputCommand = commandArgument.trim();
        if (commandArgument.isEmpty())
            throw new IllegalArgumentException("Input command is empty!");
        String[] splitCommand = inputCommand.split(DELIMITER);
        String drawCommand = splitCommand[0];

        switch (drawCommand) {
            case "C":
                return parseCanvasCommand(splitCommand);
            case "L":
                return parseLineAndRectangleCommand(splitCommand, Command.LINE);
            case "R":
                return parseLineAndRectangleCommand(splitCommand, Command.RECTANGLE);
            case "B":
                return parseFillCommand(splitCommand);
            default:
                throw new IllegalArgumentException("The input drawing command " + drawCommand + " is not supported currently."
                        + "\n" + "Valid draw commands are: C, L, R and B ; Q to Quit the program");
        }
    }

    private EnumMap<PaintingParams, Object> parseCanvasCommand(String[] splitCommand) {
        if (splitCommand.length != 3)
            throw new IllegalArgumentException("Only two inputs are expected for Canvas command, W and H");

        int width = parseInt(splitCommand[1]);
        int height = parseInt(splitCommand[2]);
        if (width < 1 || height < 1) {
            throw new IllegalArgumentException("Canvas width and height cannot be zero or negative");
        }

        EnumMap<PaintingParams, Object> resultMap = new EnumMap<>(PaintingParams.class);
        resultMap.put(PaintingParams.PAINT_COMMAND, CANVAS);
        resultMap.put(PaintingParams.WIDTH, width);
        resultMap.put(PaintingParams.HEIGHT, height);
        return resultMap;
    }

    private EnumMap<PaintingParams, Object> parseLineAndRectangleCommand(String[] splitCommand, Command command) {
        if (splitCommand.length != 5)
            throw new IllegalArgumentException("Four integers are expected as inputs: x1, y1, x2, y2");

        int x1 = parseInt(splitCommand[1]);
        int y1 = parseInt(splitCommand[2]);
        int x2 = parseInt(splitCommand[3]);
        int y2 = parseInt(splitCommand[4]);
        if (x1 < 1 || y1 < 1 || x2 < 1 || y2 < 1) {
            throw new IllegalArgumentException("The provided co-ordinates cannot be zero or negative");
        }

        EnumMap<PaintingParams, Object> resultMap = new EnumMap<>(PaintingParams.class);
        resultMap.put(PaintingParams.PAINT_COMMAND, command);
        resultMap.put(PaintingParams.X1, x1);
        resultMap.put(PaintingParams.Y1, y1);
        resultMap.put(PaintingParams.X2, x2);
        resultMap.put(PaintingParams.Y2, y2);
        return resultMap;
    }

    private EnumMap<PaintingParams, Object> parseFillCommand(String[] splitCommand) {
        if (splitCommand.length != 4)
            throw new IllegalArgumentException("Fill only expects two integers (for x,y) and single Character (for colour)");

        int x = parseInt(splitCommand[1]);
        int y = parseInt(splitCommand[2]);
        if (x < 1 || y < 1)
            throw new IllegalArgumentException("Given fill coordinates cannot be zero or negative");

        String colour = splitCommand[3];
        if (colour.length() != 1)
            throw new IllegalArgumentException("Colour parameter for fill command should be 1 character ");

        EnumMap<PaintingParams, Object> resultMap = new EnumMap<>(PaintingParams.class);
        resultMap.put(PaintingParams.PAINT_COMMAND, FILL);
        resultMap.put(PaintingParams.X, x);
        resultMap.put(PaintingParams.Y, y);
        resultMap.put(PaintingParams.COLOUR, colour.charAt(0));
        return resultMap;
    }
}
