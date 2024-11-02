package sandbox.regexp;

import java.util.regex.Pattern;

public class RegExprDemo3 {

    public static void main(String[] args) {
        var pat = Pattern.compile("test");
        var mat = pat.matcher("test 1 2 3 test");

        while (mat.find()) {
            System.out.println(String.format("test sound at index: %d", mat.start()));
        }

    }
}
