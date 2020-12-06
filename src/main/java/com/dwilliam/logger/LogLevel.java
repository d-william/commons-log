package com.dwilliam.logger;

import java.util.HashMap;
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
    LogLevel TRACE = new LogLevelImpl(LOG_TYPE_VALUES.get(LogType.TRACE));
    LogLevel VERBOSE = new LogLevelImpl(LOG_TYPE_VALUES.get(LogType.VERBOSE));
    LogLevel DEBUG = new LogLevelImpl(LOG_TYPE_VALUES.get(LogType.DEBUG));
    LogLevel INFO = new LogLevelImpl(LOG_TYPE_VALUES.get(LogType.INFO));
    LogLevel NOTICE = new LogLevelImpl(LOG_TYPE_VALUES.get(LogType.NOTICE));
    LogLevel WARNING = new LogLevelImpl(LOG_TYPE_VALUES.get(LogType.WARNING));
    LogLevel ERROR = new LogLevelImpl(LOG_TYPE_VALUES.get(LogType.ERROR));
    LogLevel FATAL = new LogLevelImpl(LOG_TYPE_VALUES.get(LogType.FATAL));
    LogLevel WTF = new LogLevelImpl(LOG_TYPE_VALUES.get(LogType.WTF));
    LogLevel OFF = new LogLevelImpl(Integer.MAX_VALUE);

    Map<String, LogLevel> LOG_LEVEL_VALUES = new HashMap<>(Map.ofEntries(
            Map.entry("ALL", ALL),
            Map.entry("TRACE", TRACE),
            Map.entry("VERBOSE", VERBOSE),
            Map.entry("DEBUG", DEBUG),
            Map.entry("INFO", INFO),
            Map.entry("NOTICE", NOTICE),
            Map.entry("WARNING", WARNING),
            Map.entry("ERROR", ERROR),
            Map.entry("FATAL", FATAL),
            Map.entry("WTF", WTF),
            Map.entry("OFF", OFF)
    ));

    static LogLevel valueOf(String value) {
        return LOG_LEVEL_VALUES.get(value);
    }

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
