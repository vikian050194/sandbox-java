package sandbox.regexp;

import java.util.regex.Pattern;

public class RegExprDemo8 {

    public static void main(String[] args) {
        var str = "Jon Jonathan Frank Ken Todd";

        var pat = Pattern.compile("Jon.*? ");
        var mat = pat.matcher(str);

        System.out.println(String.format("Original: %s", str));

        str = mat.replaceAll("Eric ");

        System.out.println(String.format("Modified: %s", str));

    }
}
