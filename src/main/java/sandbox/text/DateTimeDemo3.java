package sandbox.text;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeDemo3 {

    public static void main(String[] args) {
        var full = LocalDateTime.now();

        System.out.println(full.format(DateTimeFormatter.ofPattern("MMMM d',' yyy h':'mm a")));
    }
}
