package sandbox.io;

import java.io.File;

public class DirListOnly {

    private static void p(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        var f1 = new File("/home/kirill/Documents");
        var pattern = ".pdf";

        var s = f1.list((dir, name) -> name.endsWith(pattern));

        for (var si : s) {
            p(si);
        }
    }
}
