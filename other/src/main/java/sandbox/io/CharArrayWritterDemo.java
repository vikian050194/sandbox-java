package sandbox.io;

import java.io.*;

public class CharArrayWritterDemo {

    public static void main(String[] args) throws IOException {
        var f = new CharArrayWriter();
        var s = "This should end up in the array";
        var b = new char[s.length()];

        try {
            f.write(b);
        } catch (IOException e) {
            System.err.println("Error Writing to Buffer");
            return;
        }

        System.out.println("Buffer as a string");
        System.out.println(f.toString());
        System.out.println("Into array");
        var c = f.toCharArray();
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]);
        }

        System.out.println("To a FileWriter()");

        try (var f2 = new FileWriter("test.txt")) {
            f.writeTo(f2);
        } catch (IOException e) {
            System.err.println("I/O Error: " + e);
            return;
        }
        System.out.println("Doing a reset");
        f.reset();

        for (int i = 0; i < 3; i++) {
            f.write('X');
        }

        System.out.println(f.toString());
    }
}
