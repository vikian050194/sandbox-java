package sandbox.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExprDemo2 {

    public static void main(String[] args) {
        Pattern pat;
        Matcher mat;
        boolean found;

        pat = Pattern.compile("Java");
        mat = pat.matcher("Java SE");
        found = mat.find();

        System.out.println("Looking for Java in Java SE");
        System.out.println(String.format("Found: %s", found));
    }
}
