package sandbox.nio;

import java.io.*;
import java.nio.*;
import java.nio.file.*;

public class ExplicitChannelWrite {

    public static void main(String[] args) {
        try (var fChan = Files.newByteChannel(Path.of("test.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            var mBuf = ByteBuffer.allocate(26);

            for (int i = 0; i < 26; i++) {
                mBuf.put((byte) ('A' + i));
            }

            mBuf.rewind();

            fChan.write(mBuf);
        } catch (InvalidPathException e) {
            System.err.println("Path Error: " + e);
        } catch (IOException e) {
            System.err.println("I/O Error: " + e);
        }
    }
}
