package sandbox.io;

import java.io.*;
import java.util.*;

class InputStreamEnumerator implements Enumeration<FileInputStream> {

    private final Enumeration<String> files;

    public InputStreamEnumerator(Vector<String> files) {
        this.files = files.elements();
    }

    @Override
    public boolean hasMoreElements() {
        return files.hasMoreElements();
    }

    @Override
    public FileInputStream nextElement() {
        try {
            return new FileInputStream(files.nextElement());
        } catch (IOException e) {
            System.err.println("I/O Error: " + e);
            return null;
        }
    }
}

public class SequanceInputStreamDemo {

    public static void main(String[] args) throws IOException {
        int c;
        var files = new Vector<String>();
        files.add("file1.txt");
        files.add("file2.txt");
        files.add("file3.txt");
        var ise = new InputStreamEnumerator(files);

        try (var input = new SequenceInputStream(ise)) {
            while ((c = input.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (NullPointerException e) {
            System.err.println("Error Opening File!");
        } catch (IOException e) {
            System.err.println("I/O Error: " + e);
        }
    }
}
