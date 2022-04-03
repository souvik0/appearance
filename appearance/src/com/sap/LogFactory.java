package com.sap;
/// This is publisher hierarchy
public interface LogFactory {

    public void attachLoggingPlatform(LoggingPlatform loggingPlatform);
    public void detachLoggingPlatform(LoggingPlatform loggingPlatform);
    public void notifyLoggingPlatform(Loglevel loglevel, LogDelivery delivery);
}
