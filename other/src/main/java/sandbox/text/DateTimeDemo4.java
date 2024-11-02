package sandbox.text;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeDemo4 {

    public static void main(String[] args) {
        var parsedDateTime = LocalDateTime.parse("June 30, 2021 12:01 AM", DateTimeFormatter.ofPattern("MMMM d',' yyyy hh':'mm a"));

        System.out.println(parsedDateTime);
    }
}
