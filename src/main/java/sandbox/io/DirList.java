package sandbox.io;

import java.io.File;

public class DirList {

    private static void p(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        var f1 = new File("/home/kirill/Documents");

        if (f1.isDirectory()) {
            p("Directory of " + f1.getPath());
            var s = f1.list();

            for (var si : s) {
                var f = new File(si);

                if (f.isDirectory()) {
                    p(si + " is a directory");
                } else {
                    p(si + " is a file");
                }
            }
        } else {
            p(f1.getPath() + " is not a directory");
        }
    }
}
