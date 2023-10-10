package sandbox.io;

import java.io.File;

public class FileDemo {

    private static void p(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        var f1 = new File("/home/kirill/.netbeans/.superId");

        p("File Name: " + f1.getName());
        p("Path: " + f1.getPath());
        p("Abs Path: " + f1.getAbsolutePath());
        p("Parent: " + f1.getParent());

        p("Exists: " + f1.exists());
        p("Can Write: " + f1.canWrite());
        p("Can Read: " + f1.canRead());
        p("Is Dir: " + f1.isDirectory());

        p("Is File: " + f1.isFile());
        p("Is Abs: " + f1.isAbsolute());

        p("File Last Modified: " + f1.lastModified());
        p("File Size: " + f1.length() + " Bytes");
    }
}
