package sandbox.io;

import java.io.*;

public class ByteArrayInputStreamDemo {

    public static void main(String[] args) throws IOException {
        var source = "abcdefghijklmnopqrstuvwxyzx";

        System.out.println(source);

        var b = source.getBytes();

        var input1 = new ByteArrayInputStream(b);
        var input2 = new ByteArrayInputStream(b, 0, 3);
    }
}
