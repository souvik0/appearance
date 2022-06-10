package com.sap;

public class ConsoleLogWriter implements LoggingPlatform{

    @Override
    public void write(Loglevel level) {
        System.out.println("Writting log message to Console having log level: " + level.toString());
    }

    @Override
    public void pushLogToDelivery(LogDelivery delivery) {
        System.out.println("Push log to : " + delivery.toString());
    }
}
