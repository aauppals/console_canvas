package org.uppal.painting;

public interface Painter {
    Canvas paint(Paintable paintable);

    Canvas paint(Fill fill);
}
