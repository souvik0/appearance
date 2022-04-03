package com.sap;

public class LoggingClient {

    public static void main(String[] args) {
        ConcreateLogFactory Logger = ConcreateLogFactory.getSingletonLazyInstance();

        LoggingPlatform fileLoggingPlatform = new FileLogWriter();
        LoggingPlatform consoleLoggingPlatform = new ConsoleLogWriter();
        LoggingPlatform aggregatorLoggingPlatform = new AggregatorLogWriter();

        Logger.attachLoggingPlatform(fileLoggingPlatform);
        Logger.attachLoggingPlatform(consoleLoggingPlatform);
        // Writting info logs to file & console & pushing to KIVANA
        Logger.notifyLoggingPlatform(Loglevel.INFO, LogDelivery.KIVANA);

        Logger.detachLoggingPlatform(consoleLoggingPlatform);
        Logger.attachLoggingPlatform(aggregatorLoggingPlatform);
        // Writting debug logs to file & aggregator & pushing to SPLUNK
        Logger.notifyLoggingPlatform(Loglevel.DEBUG, LogDelivery.SPLUNK);
    }
}
