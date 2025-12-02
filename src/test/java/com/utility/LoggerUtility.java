package com.utility;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.concurrent.ConcurrentHashMap;

public class LoggerUtility {

    private static final ConcurrentHashMap<Class<?>, Logger> loggerMap = new ConcurrentHashMap<>();

    private LoggerUtility() {
        // Prevent instantiation
    }

    public static Logger getLogger(Class<?> clazz) {
        return loggerMap.computeIfAbsent(clazz, LogManager::getLogger);
    }
}