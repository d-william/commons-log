package com.dwilliam.logger;

public class NoLogger implements Logger {

    private static NoLogger INSTANCE;

    public static NoLogger getInstance() {
        if (INSTANCE == null) INSTANCE = new NoLogger();
        return INSTANCE;
    }

    private NoLogger() {}

    @Override
    public void log(LogType type, String message) {}

}
