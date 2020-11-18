package com.dwilliam.logger;

import java.text.SimpleDateFormat;

public class StandardLogger extends OutputStreamLogger {

    public StandardLogger(String application, String version) {
        super(application, version, System.out);
    }

    public StandardLogger(String application, String version, String logPattern) {
        super(application, version, System.out, logPattern);
    }

    public StandardLogger(String application, String version, LogFormat logFormat) {
        super(application, version, System.out, logFormat);
    }

    public StandardLogger(String application, String version, SimpleDateFormat dateFormat) {
        super(application, version, System.out, dateFormat);
    }

    public StandardLogger(String application, String version, String logPattern, String datePattern) {
        super(application, version, System.out, datePattern, logPattern);
    }

    public StandardLogger(String application, String version, SimpleDateFormat dateFormat, String logPattern) {
        super(application, version, System.out, dateFormat, logPattern);
    }

}
