package stackjava.com.bookstore.util;

import java.text.SimpleDateFormat;

public class DateUtils {

    public static final String DATE_DISPLAY_FORMAT = "YYYYMMDD";

    public static SimpleDateFormat DATE_FORMAT() {
        return new SimpleDateFormat(DATE_DISPLAY_FORMAT);
    }
}