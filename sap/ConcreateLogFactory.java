package com.sap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ConcreateLogFactory implements LogFactory, Serializable, Cloneable{

    private static final long serialVersionUID = 1L;
    private static volatile ConcreateLogFactory Logger = null;
    List<LoggingPlatform> loggingPlatformList = new ArrayList<LoggingPlatform>();

    // Default private constructor
    private ConcreateLogFactory() {
        // Reflection Proofing
        if (Logger != null) {
            throw new RuntimeException("Prventing object created by reflection");
        }
    }

    // Lazy Instantiation with Double checking thread safety implemented
    public static ConcreateLogFactory getSingletonLazyInstance() {
        if (Logger == null) {
            synchronized(ConcreateLogFactory.class) {
                // Introducing double checking
                if (Logger == null) {
                    Logger = new ConcreateLogFactory();
                }
            }
        }
        return Logger;
    }

    // Serialization Proofing
    protected ConcreateLogFactory readResolve() {
        //return getSingletonLazyInstance();
        return getSingletonLazyInstance();
    }
    
    // Clone Proofing
    public ConcreateLogFactory clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    @Override
    public void attachLoggingPlatform(LoggingPlatform loggingPlatform) {
        loggingPlatformList.add(loggingPlatform);
    }

    @Override
    public void detachLoggingPlatform(LoggingPlatform loggingPlatform) {
        loggingPlatformList.remove(loggingPlatform);
    }

    @Override
    public void notifyLoggingPlatform(Loglevel loglevel, LogDelivery delivery) {
        switch(loglevel) {
        case INFO:
            for (LoggingPlatform platform : loggingPlatformList) {
                platform.write(loglevel);
                platform.pushLogToDelivery(delivery);
            }
            break;
        case ERROR:
            for (LoggingPlatform platform : loggingPlatformList) {
                platform.write(loglevel);
                platform.pushLogToDelivery(delivery);
            }
            break;
        case DEBUG:
            for (LoggingPlatform platform : loggingPlatformList) {
                platform.write(loglevel);
                platform.pushLogToDelivery(delivery);
            }
            break;
        case WARN:
            for (LoggingPlatform platform : loggingPlatformList) {
                platform.write(loglevel);
                platform.pushLogToDelivery(delivery);
            }
            break;
        }
    }
}
