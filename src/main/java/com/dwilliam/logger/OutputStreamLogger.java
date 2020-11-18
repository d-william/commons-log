package com.dwilliam.logger;

import java.io.OutputStream;
import java.text.SimpleDateFormat;

public class OutputStreamLogger extends AbstractLogger {

    private final OutputStream output;
    private final LogFormat    format;

    public OutputStreamLogger(String application, String version, OutputStream outputStream) {
        this(application, version, outputStream, new LogFormat());
    }

    public OutputStreamLogger(String application, String version, OutputStream outputStream, String logPattern) {
        this(application, version, outputStream, new LogFormat(logPattern));
    }

    public OutputStreamLogger(String application, String version, OutputStream outputStream, SimpleDateFormat dateFormat) {
        this(application, version, outputStream, new LogFormat(dateFormat));
    }

    public OutputStreamLogger(String application, String version, OutputStream outputStream, String datePattern, String logPattern) {
        this(application, version, outputStream, new LogFormat(logPattern, datePattern));
    }

    public OutputStreamLogger(String application, String version, OutputStream outputStream, SimpleDateFormat dateFormat, String logPattern) {
        this(application, version, outputStream, new LogFormat(logPattern, dateFormat));
    }

    public OutputStreamLogger(String application, String version, OutputStream outputStream, LogFormat logFormat) {
        super(application, version);
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
