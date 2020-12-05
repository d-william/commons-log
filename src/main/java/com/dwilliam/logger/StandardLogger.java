package com.dwilliam.logger;

public class StandardLogger extends OutputStreamLogger {

    public StandardLogger(LogFormat logFormat) {
        super(System.out, logFormat);
    }

    public StandardLogger(String application, LogFormat logFormat) {
        super(application, System.out, logFormat);
    }

    public StandardLogger(String application, String version, LogFormat logFormat) {
        super(application, version, System.out, logFormat);
    }

    public StandardLogger(String application, String version, LogLevel level, LogFormat logFormat) {
        super(application, version, level, System.out, logFormat);
    }
    
}
