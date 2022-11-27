package utils;

import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;

public class PatternLayoutayout extends Layout {
    @Override
    public void activateOptions() {

    }

    @Override
    public String format(LoggingEvent loggingEvent) {
        return null;
    }

    @Override
    public boolean ignoresThrowable() {
        return false;
    }
}
