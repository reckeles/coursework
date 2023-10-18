package org.coursework.config.enums;

public enum Environment {
    DEV,
    LOCAL,
    GRID;

    public String getEnvName() {
        return this.name().toLowerCase();
    }
}
