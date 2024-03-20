package sandbox.regexp;

import java.util.regex.Pattern;

public class RegExprDemo6 {

    public static void main(String[] args) {
        var pat = Pattern.compile("e.+?d");
        var mat = pat.matcher("extend cup end table");

        while (mat.find()) {
            System.out.println(String.format("Match: %s", mat.group()));
        }

    }
}
