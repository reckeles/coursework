package org.coursework.config;

public enum TextLocale {
    EN;

    public String getLocale() {
        return this.name().toLowerCase();
    }
}
