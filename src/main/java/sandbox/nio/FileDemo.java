package sandbox.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class FileDemo {

    private static void p(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        var filepath = Path.of("src/main/java/sandbox/nio/FileDemo.java");

        p("File Name: " + filepath.getName(1));
        p("Path: " + filepath);
        p("Abs Path: " + filepath.toAbsolutePath());
        p("Parent: " + filepath.getParent());

        try {
            p("Hidden: " + Files.isHidden(filepath));
        } catch (IOException e) {
            System.err.println("I/O Error: " + e);
        }

        p("Exists: " + Files.exists(filepath));
        p("Can Write: " + Files.isWritable(filepath));
        p("Can Read: " + Files.isReadable(filepath));
        p("Is Dir: " + Files.isDirectory(filepath));

        p("Is File: " + Files.isRegularFile(filepath));

        try {
            var atr = Files.readAttributes(filepath, BasicFileAttributes.class);
            p("Is Dir: " + atr.isDirectory());
            p("Is Regular File: " + atr.isRegularFile());
            p("Is Sym Link: " + atr.isSymbolicLink());
            p("Last access time: " + atr.lastAccessTime());
            p("Last modified time: " + atr.lastModifiedTime());
            p("Size: " + atr.size());
        } catch (IOException e) {
            System.err.println("Error reading attributes: " + e);
        }
    }
}
