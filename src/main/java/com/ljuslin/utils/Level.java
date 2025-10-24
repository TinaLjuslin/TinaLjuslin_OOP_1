package com.ljuslin.utils;

public enum Level {
    STANDARD,
    STUDENT,
    PREMIUM;
    @Override
    public String toString() {
        return this.name().substring(0, 1).toUpperCase() + this.name().substring(1).toLowerCase();
    }
}
