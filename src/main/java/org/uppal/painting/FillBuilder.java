package org.uppal.painting;

import org.uppal.inputCommand.PaintingParams;

import java.util.Map;

import static org.uppal.inputCommand.PaintingParams.*;

public class FillBuilder {

    public Fill build(Map<PaintingParams, Object> parsedCommand) throws Exception {
        return new Fill(new Coordinate((Integer) parsedCommand.get(X), (Integer) parsedCommand.get(Y)), (Character) parsedCommand.get(COLOUR));
    }
}