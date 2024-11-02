package sandbox.io;

import java.io.*;

public class FileReaderDemo {

    public static void main(String[] args) {
        try (var fr = new FileReader("./src/main/java/sandbox/io/FileReaderDemo.java")) {
            int c;

            while ((c = fr.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            System.err.println("I/O Error: " + e);
        }
    }
}
