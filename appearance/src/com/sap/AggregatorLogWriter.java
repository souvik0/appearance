package com.sap;

public class AggregatorLogWriter implements LoggingPlatform{

    @Override
    public void write(Loglevel level) {
        System.out.println("Writting log message to Log Aggregator having log level: " + level.toString());
    }

    @Override
    public void pushLogToDelivery(LogDelivery delivery) {
        System.out.println("Push log to : " + delivery.toString());
    }
}
