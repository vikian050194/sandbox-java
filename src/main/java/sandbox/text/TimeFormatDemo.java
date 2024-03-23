package sandbox.text;

import java.text.DateFormat;
import java.util.*;

public class TimeFormatDemo {

    public static void main(String[] args) {
        var date = new Date();
        DateFormat df;

        df = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.JAPAN);
        System.out.println(String.format("Japan: %s", df.format(date)));

        df = DateFormat.getTimeInstance(DateFormat.LONG, Locale.UK);
        System.out.println(String.format("UK: %s", df.format(date)));

        df = DateFormat.getTimeInstance(DateFormat.FULL, Locale.CANADA);
        System.out.println(String.format("Canada: %s", df.format(date)));
    }
}
