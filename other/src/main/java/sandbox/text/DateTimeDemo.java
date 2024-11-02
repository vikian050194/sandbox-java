package sandbox.text;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateTimeDemo {

    public static void main(String[] args) {
        var time = LocalTime.now();

        System.out.println(time);

        var date = LocalDate.now();
        System.out.println(date);

        var full = LocalDateTime.now();
        System.out.println(full);
    }
}
