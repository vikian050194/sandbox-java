package sandbox.nio;

import java.io.*;
import java.nio.*;
import java.nio.file.*;

public class ExplicitChannelRead {

    public static void main(String[] args) {
        int count;

        try (var fChan = Files.newByteChannel(Path.of("test.txt"))) {
            var mBuf = ByteBuffer.allocate(128);

            do {
                count = fChan.read(mBuf);

                if (count != -1) {
                    mBuf.rewind();

                    for (int i = 0; i < count; i++) {
                        System.out.print((char) mBuf.get());
                    }
                }
            } while (count != -1);

            System.out.println();
        } catch (InvalidPathException e) {
            System.err.println("Path Error: " + e);
        } catch (IOException e) {
            System.err.println("I/O Error: " + e);
        }
    }
}
