package sandbox.regexp;

import java.util.regex.Pattern;

public class RegExprDemo9 {

    public static void main(String[] args) {
        var str = "one two,alpha9 12!done.";

        var pat = Pattern.compile("[ ,.!]");

        var chunks = pat.split(str);

        for (String chunk : chunks) {
            System.out.println(String.format("Next token: %s", chunk));
        }

    }
}
