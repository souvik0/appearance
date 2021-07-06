package com.sap;

public enum LogDelivery {

    SPLUNK("SPLUNK"),
    KIVANA("KIVANA");

    private final String logDelivery;

    LogDelivery(String logDelivery) {
        this.logDelivery = logDelivery;
    }

    public String toString() {
        return logDelivery;
    }
}
