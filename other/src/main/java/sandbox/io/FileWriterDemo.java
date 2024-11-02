package sandbox.io;

import java.io.*;

public class FileWriterDemo {

    public static void main(String[] args) {
        var source = """
                     Now it the time for all good man
                      to come to aid of their country
                      and pay their due taxes.
                     """;

        System.out.println(source);

        var buffer = new char[source.length()];
        source.getChars(0, source.length(), buffer, 0);

        try (var f1 = new FileWriter("file1.txt"); var f2 = new FileWriter("file2.txt"); var f3 = new FileWriter("file3.txt")) {

            //write to first file
            for (int i = 0; i < buffer.length; i += 2) {
                f1.write(buffer[i]);
            }

            //write to second file
            f2.write(buffer);

            //write to third file
            f3.write(buffer, buffer.length - buffer.length / 4, buffer.length / 4);
        } catch (IOException e) {
            System.err.println("Error: " + e);
        }
    }
}
