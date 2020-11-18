package com.dwilliam.logger;

public class Log {

    public final long timestamp;
    public final LogType type;
    public final long pid;
    public final String application;
    public final String version;
    public final String message;

    public Log(long timestamp, LogType type, long pid, String application, String version, String message) {
        this.timestamp = timestamp;
        this.type = type;
        this.pid = pid;
        this.application = application;
        this.version = version;
        this.message = message;
    }

}
