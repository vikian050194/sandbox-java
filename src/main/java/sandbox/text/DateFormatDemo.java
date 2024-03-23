package sandbox.text;

import java.text.DateFormat;
import java.util.*;

public class DateFormatDemo {

    public static void main(String[] args) {
        var date = new Date();
        DateFormat df;

        df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.JAPAN);
        System.out.println(String.format("Japan: %s", df.format(date)));

        df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.KOREA);
        System.out.println(String.format("Korea: %s", df.format(date)));

        df = DateFormat.getDateInstance(DateFormat.LONG, Locale.UK);
        System.out.println(String.format("UK: %s", df.format(date)));

        df = DateFormat.getDateInstance(DateFormat.FULL, Locale.US);
        System.out.println(String.format("US: %s", df.format(date)));
    }
}
