package com.dwilliam.logger;

import java.util.Map;

public interface LogLevel {

    Map<LogType, Integer> LOG_TYPE_VALUES = Map.of(
            LogType.TRACE,   100,
            LogType.VERBOSE, 200,
            LogType.DEBUG,   300,
            LogType.INFO,    400,
            LogType.NOTICE,  500,
            LogType.WARNING, 600,
            LogType.ERROR,   700,
            LogType.FATAL,   800,
            LogType.WTF,     900
    );

    LogLevel ALL = new LogLevelImpl(Integer.MIN_VALUE);
    LogLevel TRACE = new LogLevelImpl(100);
    LogLevel VERBOSE = new LogLevelImpl(200);
    LogLevel DEBUG = new LogLevelImpl(300);
    LogLevel INFO = new LogLevelImpl(400);
    LogLevel NOTICE = new LogLevelImpl(500);
    LogLevel WARNING = new LogLevelImpl(600);
    LogLevel ERROR = new LogLevelImpl(700);
    LogLevel FATAL = new LogLevelImpl(800);
    LogLevel WTF = new LogLevelImpl(900);
    LogLevel OFF = new LogLevelImpl(Integer.MAX_VALUE);

    boolean isLoggable(LogType type);

    class LogLevelImpl implements LogLevel {

        private final int value;

        public LogLevelImpl(int value) {
            this.value = value;
        }

        @Override
        public boolean isLoggable(LogType type) {
            return LOG_TYPE_VALUES.get(type) >= this.value;
        }

    }

    default boolean isTraceEnabled() {
        return isLoggable(LogType.TRACE);
    }

    default boolean isVerboseEnabled() {
        return isLoggable(LogType.VERBOSE);
    }

    default boolean isDebugEnabled() {
        return isLoggable(LogType.DEBUG);
    }

    default boolean isInfoEnabled() {
        return isLoggable(LogType.INFO);
    }

    default boolean isNoticeEnabled() {
        return isLoggable(LogType.NOTICE);
    }

    default boolean isWarningEnabled() {
        return isLoggable(LogType.WARNING);
    }

    default boolean isErrorEnabled() {
        return isLoggable(LogType.ERROR);
    }

    default boolean isFatalEnabled() {
        return isLoggable(LogType.FATAL);
    }

    default boolean isWtfEnabled() {
        return isLoggable(LogType.WTF);
    }

}
