package sandbox.regexp;

import java.util.regex.Pattern;

public class RegExprDemo4 {

    public static void main(String[] args) {
        var pat = Pattern.compile("W+");
        var mat = pat.matcher("W WW WWW");

        while (mat.find()) {
            System.out.println(String.format("Match: %s", mat.group()));
        }

    }
}
