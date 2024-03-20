package sandbox.regexp;

import java.util.regex.Pattern;

public class RegExprDemo7 {

    public static void main(String[] args) {
        var pat = Pattern.compile("[a-z]+");
        var mat = pat.matcher("this is not the end");

        while (mat.find()) {
            System.out.println(String.format("Match: %s", mat.group()));
        }

    }
}
