package org.uppal.painting;

import org.uppal.inputCommand.Command;
import org.uppal.inputCommand.PaintingParams;

import java.util.Map;

import static org.uppal.inputCommand.PaintingParams.*;

public class DrawableBuilder {
    public Drawable build(Map<PaintingParams, Object> parsedCommand) {
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
