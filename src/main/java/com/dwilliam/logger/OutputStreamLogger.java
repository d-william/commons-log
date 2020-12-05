package com.dwilliam.logger;

import java.io.OutputStream;

public class OutputStreamLogger extends AbstractLogger {

    private final static LogFormat DEFAULT_LOG_FORMAT = new LogFormat();

    private final OutputStream output;
    private final LogFormat    format;

    public OutputStreamLogger(OutputStream outputStream, LogFormat logFormat) {
        super();
        this.output = outputStream;
        this.format = logFormat;
    }

    public OutputStreamLogger(String application, OutputStream outputStream, LogFormat logFormat) {
        super(application);
        this.output = outputStream;
        this.format = logFormat;
    }

    public OutputStreamLogger(String application, String version, OutputStream outputStream, LogFormat logFormat) {
        super(application, version);
        this.output = outputStream;
        this.format = logFormat;
    }

    public OutputStreamLogger(String application, String version, LogLevel level, OutputStream outputStream, LogFormat logFormat) {
        super(application, version, level);
        this.output = outputStream;
        this.format = logFormat;
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
