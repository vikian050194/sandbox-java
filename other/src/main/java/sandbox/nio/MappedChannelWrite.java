package sandbox.nio;

import java.io.*;
import java.nio.channels.*;
import java.nio.file.*;

public class MappedChannelWrite {

    public static void main(String[] args) {
        try (var fChan = (FileChannel) Files.newByteChannel(Path.of("test.txt"),
                StandardOpenOption.WRITE,
                StandardOpenOption.READ,
                StandardOpenOption.CREATE)) {
            var mBuf = fChan.map(FileChannel.MapMode.READ_WRITE, 0, 26);

            for (int i = 0; i < 26; i++) {
                mBuf.put((byte) ('A' + i));
            }
        } catch (InvalidPathException e) {
            System.err.println("Path Error: " + e);
        } catch (IOException e) {
            System.err.println("I/O Error: " + e);
        }
    }
}
