package org.coursework.config;

public enum Environment {
    DEV,
    LOCAL;

    public String getEnvName() {
        return this.name().toLowerCase();
    }
}
