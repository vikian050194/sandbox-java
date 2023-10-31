package sandbox.nio;

import java.io.*;
import java.nio.file.*;

public class NIOCopy {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: Copy from to:");
            return;
        }

        try {
            var source = Path.of(args[0]);
            var target = Path.of(args[1]);

            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            System.out.println();
        } catch (InvalidPathException e) {
            System.err.println("Path Error: " + e);
        } catch (IOException e) {
            System.err.println("I/O Error: " + e);
        }
    }
}
