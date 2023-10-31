package sandbox.nio;

import java.io.*;
import java.nio.file.*;

public class ShowFile {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: ShowFile filename:");
            return;
        }

        int i;

        var source = Path.of(args[0]);

        try (var fin = Files.newInputStream(source)) {
            do {
                i = fin.read();
                if (i != -1) {
                    System.out.println((char) i);
                }
            } while (i != -1);

            System.out.println();
        } catch (InvalidPathException e) {
            System.err.println("Path Error: " + e);
        } catch (IOException e) {
            System.err.println("I/O Error: " + e);
        }
    }
}
