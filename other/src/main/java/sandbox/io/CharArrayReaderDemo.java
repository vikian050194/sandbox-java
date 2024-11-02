package sandbox.io;

import java.io.CharArrayReader;
import java.io.IOException;

public class CharArrayReaderDemo {

    public static void main(String[] args) {
        var source = "abcdefghijklmnopqrstuvwxyzx";

        System.out.println(source);

        var length = source.length();
        var c = new char[length];
        source.getChars(0, length, c, 0);
        int i;

        try (var input = new CharArrayReader(c)) {
            System.out.println("first input is:");
            while ((i = input.read()) != -1) {
                System.out.print((char) i);
            }
            System.out.println();
        } catch (IOException e) {
            System.err.println("I/O Error: " + e);
        }

        try (var input = new CharArrayReader(c, 0, 5)) {
            System.out.println("second input is:");
            while ((i = input.read()) != -1) {
                System.out.print((char) i);
            }
            System.out.println();
        } catch (IOException e) {
            System.err.println("I/O Error: " + e);
        }
    }
}
