
package org.uppal.inputCommand;

import org.jetbrains.annotations.Nullable;

public enum Command {
    CANVAS("C"),
    LINE("L"),
    RECTANGLE("R"),
    FILL("F");

    private final String value;

    Command(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    Command commandValue(String string) {
        Command[] values = values();
        for (int i = 0; i < values.length; i++) {
            Command command = values[i];
            if (command.getValue().equals(string)) {
                return command;
            }
        }
        return null;
    }
}


