package org.uppal.painting;

public interface Drawer {
    Canvas draw(Drawable drawable);
    Canvas draw(Fill fill);
}
