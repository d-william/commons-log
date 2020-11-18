package com.dwilliam.logger;

import java.util.ArrayList;
import java.util.Collection;

public class LoggerList extends ArrayList<Logger> implements Logger {

    public LoggerList() {
        super();
    }

    public LoggerList(Collection<Logger> loggers) {
        super(loggers);
    }

    @Override
    public void log(LogType type, String message) {
        this.forEach(logger -> logger.log(type, message));
    }

}
