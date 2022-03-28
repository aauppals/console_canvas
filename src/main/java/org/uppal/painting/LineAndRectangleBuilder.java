package org.uppal.painting;

import org.uppal.inputcommand.Command;
import org.uppal.inputcommand.PaintingParams;

import java.util.Map;

import static org.uppal.inputcommand.PaintingParams.*;

public class LineAndRectangleBuilder {
    public Painter build(Map<PaintingParams, Object> parsedCommand) {
        Command command = (Command) parsedCommand.get(PaintingParams.PAINT_COMMAND);

        switch (command) {
            case LINE:
                return new Line(
                        new Coordinate((Integer) parsedCommand.get(PaintingParams.X1), (Integer) parsedCommand.get(Y1)),
                        new Coordinate((Integer) parsedCommand.get(X2), (Integer) parsedCommand.get(Y2)));
            case RECTANGLE:
                return new Rectangle(
                        new Coordinate((Integer) parsedCommand.get(X1), (Integer) parsedCommand.get(Y1)),
                        new Coordinate((Integer) parsedCommand.get(X2), (Integer) parsedCommand.get(Y2)));
        }
        return null;
    }
}
