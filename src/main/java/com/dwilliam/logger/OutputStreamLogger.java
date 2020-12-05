package com.dwilliam.logger;

import java.io.OutputStream;
import java.util.Objects;

public class OutputStreamLogger extends AbstractLogger {

    private final static LogFormat DEFAULT_LOG_FORMAT = new LogFormat();

    private final OutputStream output;
    private final LogFormat    format;

    public OutputStreamLogger(OutputStream outputStream) {
        this(outputStream, DEFAULT_LOG_FORMAT);
    }

    public OutputStreamLogger(OutputStream outputStream, LogFormat logFormat) {
        super();
        this.output = Objects.requireNonNull(outputStream);
        this.format = Objects.requireNonNull(logFormat);
    }

    public OutputStreamLogger(String application, OutputStream outputStream) {
        this(application, outputStream, DEFAULT_LOG_FORMAT);
    }

    public OutputStreamLogger(String application, OutputStream outputStream, LogFormat logFormat) {
        super(application);
        this.output = Objects.requireNonNull(outputStream);
        this.format = Objects.requireNonNull(logFormat);
    }

    public OutputStreamLogger(String application, String version, OutputStream outputStream) {
        this(application, version, outputStream, DEFAULT_LOG_FORMAT);
    }

    public OutputStreamLogger(String application, String version, OutputStream outputStream, LogFormat logFormat) {
        super(application, version);
        this.output = Objects.requireNonNull(outputStream);
        this.format = Objects.requireNonNull(logFormat);
    }

    public OutputStreamLogger(String application, String version, LogLevel level, OutputStream outputStream) {
        this(application, version, level, outputStream, DEFAULT_LOG_FORMAT);
    }

    public OutputStreamLogger(String application, String version, LogLevel level, OutputStream outputStream, LogFormat logFormat) {
        super(application, version, level);
        this.output = Objects.requireNonNull(outputStream);
        this.format = Objects.requireNonNull(logFormat);
    }

    @Override
    protected void log(Log log) {
        try {
            output.write(format.format(log).getBytes());
            output.write('\n');
            output.flush();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
