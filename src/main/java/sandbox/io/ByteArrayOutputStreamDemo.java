package sandbox.io;

import java.io.*;

public class ByteArrayOutputStreamDemo {

    public static void main(String[] args) throws IOException {
        var f = new ByteArrayOutputStream();
        var s = "This should end up in the array";
        var b = s.getBytes();

        try {
            f.write(b);
        } catch (IOException e) {
            System.err.println("Error Writing to Buffer");
            return;
        }

        System.out.println("Buffer as a string");
        System.out.println(f.toString());
        System.out.println("Into array");
        b = f.toByteArray();
        for (int i = 0; i < b.length; i++) {
            System.out.print((char) b[i]);
        }

        System.out.println("To an OutputStream()");

        try (var f2 = new FileOutputStream("test.txt")) {
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
