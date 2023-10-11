package sandbox.io;

import java.io.*;

public class FileOutputStreamDemo {

    public static void main(String[] args) throws IOException {
        var source = """
                     Now it the time for all good man
                      to come to aid of their country
                      and pay their due taxes.
                     """;

        System.out.println(source);

        var buf = source.getBytes();

        try (var f1 = new FileOutputStream("file1.txt"); var f2 = new FileOutputStream("file2.txt"); var f3 = new FileOutputStream("file3.txt")) {

            //write to first file
            for (int i = 0; i < buf.length; i += 2) {
                f1.write(buf[i]);
            }

            //write to second file
            f2.write(buf);

            //write to third file
            f3.write(buf, buf.length - buf.length / 4, buf.length / 4);
        } catch (IOException e) {
            System.err.println("Error: " + e);
        }
    }
}
