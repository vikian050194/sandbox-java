package sandbox.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class DirList {

    public static void main(String[] args) {
        var filepath = Path.of("src/");

        try (var dirstrm = Files.newDirectoryStream(filepath)) {
            System.out.printf("Directory of %s%n", filepath);

            for (var entry : dirstrm) {
                var atrs = Files.readAttributes(entry, BasicFileAttributes.class);
                if (atrs.isDirectory()) {
                    System.out.print("<DIR> ");
                } else {
                    System.out.print("      ");
                }

                System.out.println(entry.getName(1));
            }

        } catch (InvalidPathException e) {
            System.err.println("Path Error: " + e);
        } catch (NotDirectoryException e) {
            System.err.printf("%s is not a directory%n", filepath);
        } catch (IOException e) {
            System.err.println("I/O Error: " + e);
        }
    }
}
