package sandbox.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExprDemo {

    public static void main(String[] args) {
        Pattern pat;
        Matcher mat;
        boolean found;

        pat = Pattern.compile("Java");
        mat = pat.matcher("Java");
        found = mat.matches();

        System.out.println("Testing Java against Java");
        System.out.println(String.format("Mathes: %s", found));

        mat = pat.matcher("Java SE");
        found = mat.matches();

        System.out.println("Testing Java against Java SE");
        System.out.println(String.format("Mathes: %s", found));
    }
}
