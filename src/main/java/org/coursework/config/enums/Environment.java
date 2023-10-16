package org.coursework.config.enums;

public enum Environment {
    DEV,
    LOCAL;

    public String getEnvName() {
        return this.name().toLowerCase();
    }
}
