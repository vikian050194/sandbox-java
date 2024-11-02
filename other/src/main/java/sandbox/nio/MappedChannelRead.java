package sandbox.nio;

import java.io.*;
import java.nio.channels.*;
import java.nio.file.*;

public class MappedChannelRead {

    public static void main(String[] args) {
        try (var fChan = (FileChannel) Files.newByteChannel(Path.of("test.txt"))) {
            var fSize = fChan.size();

            var mBuf = fChan.map(FileChannel.MapMode.READ_ONLY, 0, fSize);

            for (int i = 0; i < fSize; i++) {
                System.out.print((char) mBuf.get());
            }

            System.out.println();
        } catch (InvalidPathException e) {
            System.err.println("Path Error: " + e);
        } catch (IOException e) {
            System.err.println("I/O Error: " + e);
        }
    }
}
