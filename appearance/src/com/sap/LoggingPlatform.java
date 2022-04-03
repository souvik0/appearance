package com.sap;
// This is observer hierarchy
public interface LoggingPlatform {

    public void write(Loglevel loglevel);
    public void pushLogToDelivery(LogDelivery delivery);
}
