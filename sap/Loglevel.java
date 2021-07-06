package com.sap;

public enum Loglevel {

    INFO("INFO"),
    ERROR("ERROR"),
    DEBUG("DEBUG"),
    WARN("WARN");

    private final String logLevel;

    Loglevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public String toString() {
        return logLevel;
    }
}
