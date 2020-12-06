package com.dwilliam.logger;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

// TODO
// javadoc

public class LogFormat {

    private static final String TIMESTAMP_FIELD   = "%t";
    private static final String LEVEL_FIELD       = "%l";
    private static final String PID_FIELD         = "%p";
    private static final String APPLICATION_FIELD = "%a";
    private static final String MESSAGE_FIELD     = "%m";

    private static final char TIMESTAMP_CHAR   = 't';
    private static final char LEVEL_CHAR       = 'l';
    private static final char PID_CHAR         = 'p';
    private static final char APPLICATION_CHAR = 'a';
    private static final char MESSAGE_CHAR     = 'm';

    private static final char SPECIAL_CHAR = '%';

    private final String[]         pattern;
    private final SimpleDateFormat dateFormat;

    public LogFormat() {
        this("%t %p %l:%m");
    }

    public LogFormat(String logPattern) {
        this(logPattern, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"));
    }

    public LogFormat(SimpleDateFormat dateFormat) {
        this("%t %p/%c %l:%m", dateFormat);
    }

    public LogFormat(String logPattern, String datePattern) {
        this(logPattern, new SimpleDateFormat(datePattern));
    }

    public LogFormat(String logPattern, SimpleDateFormat dateFormat) {
        if (logPattern == null) throw new NullPointerException("the given log pattern is null");
        this.dateFormat = dateFormat;
        boolean isSpecial = false;
        List<String> pattern = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : logPattern.toCharArray()) {
            if (isSpecial) {
                switch (c) {
                    case TIMESTAMP_CHAR:
                        pattern.add(TIMESTAMP_FIELD);
                        break;
                    case LEVEL_CHAR:
                        pattern.add(LEVEL_FIELD);
                        break;
                    case PID_CHAR:
                        pattern.add(PID_FIELD);
                        break;
                    case APPLICATION_CHAR:
                        pattern.add(APPLICATION_FIELD);
                        break;
                    case MESSAGE_CHAR:
                        pattern.add(MESSAGE_FIELD);
                        break;
                    default:
                        throw new IllegalArgumentException("the given log pattern is invalid");
                }
                isSpecial = false;
            }
            else {
                if (c == SPECIAL_CHAR) {
                    isSpecial = true;
                    if (!sb.toString().isEmpty()) pattern.add(sb.toString());
                    sb = new StringBuilder();
                }
                else sb.append(c);
            }
        }
        if (!sb.toString().isEmpty()) pattern.add(sb.toString());
        this.pattern = pattern.toArray(new String[0]);
    }

    public final String format(Log log) {
        StringBuilder sb = new StringBuilder();
        for (String str : pattern) switch (str) {
            case TIMESTAMP_FIELD:
                sb.append(dateFormat.format(log.timestamp));
                break;
            case LEVEL_FIELD:
                sb.append(log.type);
                break;
            case PID_FIELD:
                sb.append(log.pid);
                break;
            case APPLICATION_FIELD:
                sb.append(log.application);
                break;
            case MESSAGE_FIELD:
                sb.append(log.message);
                break;
            default:
                sb.append(str);
                break;
        }
        return sb.toString();
    }

}
