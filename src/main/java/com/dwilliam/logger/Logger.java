package com.dwilliam.logger;

public interface Logger {

    void log(LogType type, String message);

    default void trace(String message) {
        log(LogType.TRACE, message);
    }

    default void verbose(String message) {
        log(LogType.VERBOSE, message);
    }

    default void debug(String message) {
        log(LogType.DEBUG, message);
    }

    default void info(String message) {
        log(LogType.INFO, message);
    }

    default void notice(String message) {
        log(LogType.NOTICE, message);
    }

    default void warning(String message) {
        log(LogType.WARNING, message);
    }

    default void error(String message) {
        log(LogType.ERROR, message);
    }

    default void fatal(String message) {
        log(LogType.FATAL, message);
    }

    default void wtf(String message) {
        log(LogType.WTF, message);
    }

}
