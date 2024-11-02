package sandbox.text;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTimeDemo2 {

    public static void main(String[] args) {
        var time = LocalTime.now();

        System.out.println(time.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)));

        var date = LocalDate.now();
        System.out.println(date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
    }
}
