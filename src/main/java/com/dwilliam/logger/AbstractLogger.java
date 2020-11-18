package com.dwilliam.logger;

import java.util.Objects;

public abstract class AbstractLogger implements Logger {

    private final long PID = ProcessHandle.current().pid();

    private final String application;
    private final String version;
    private final LogLevel level;

    public AbstractLogger(String application, String version, LogLevel level) {
        this.application = application;
        this.version = version;
        this.level = Objects.requireNonNull(level);
    }

    public AbstractLogger(String application, String version) {
        this(application, version, LogLevel.ALL);
    }

    protected abstract void log(Log log);

    public final void log(LogType type, String message) {
        if (this.level.isLoggable(type)) log(new Log(System.currentTimeMillis(), type, PID, message, this.application, this.version));
    }

}
