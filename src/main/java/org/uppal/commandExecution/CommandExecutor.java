package org.uppal.commandExecution;

import org.uppal.inputCommand.Command;
import org.uppal.inputCommand.CommandParser;
import org.uppal.inputCommand.PaintingParams;
import org.uppal.painting.Canvas;
import org.uppal.painting.DrawableBuilder;
import org.uppal.painting.Drawer;

import java.util.HashMap;
import java.util.Map;

import static org.uppal.inputCommand.PaintingParams.PAINT_COMMAND;

public class CommandExecutor {
    private static final CommandParser commandParser = new CommandParser();
    private static final HashMap<String, String> factories = new HashMap<>();

    private Canvas canvas;
    private Drawer drawer;
//
//    static {
//        DrawableBuilder drawableBuilder = new DrawableBuilder();
//        factories = ImmutableMap.of(
//
//
//        );
//
//    }
//
//    public String execute(String inputCommand) {
//        try {
//            Map<PaintingParams, Object> parsedCommand = commandParser.parse(inputCommand);
//            Command command = (Command) parsedCommand.get(PAINT_COMMAND);
//            Object object =
//        }
//    }
}
