package sandbox.nio;

import java.io.*;
import java.nio.file.*;

public class NIOStreamWrite {

    public static void main(String[] args) {
        try (var fout = new BufferedOutputStream(Files.newOutputStream(Path.of("test.txt")))) {

            for (int i = 0; i < 26; i++) {
                fout.write((byte) ('A' + i));
            }
        } catch (InvalidPathException e) {
            System.err.println("Path Error: " + e);
        } catch (IOException e) {
            System.err.println("I/O Error: " + e);
        }
    }
}
