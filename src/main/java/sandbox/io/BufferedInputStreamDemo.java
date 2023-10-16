package sandbox.io;

import java.io.*;

public class BufferedInputStreamDemo {

    public static void main(String[] args) throws IOException {
        var source = "This is &copy; copyright symbol and this is &copy not!";

        var b = source.getBytes();

        var in = new ByteArrayInputStream(b);
        int c;
        var isMarked = false;

        try (var f = new BufferedInputStream(in)) {
            while ((c = f.read()) != -1) {
                switch (c) {
                    case '&' -> {
                        if (!isMarked) {
                            f.mark(32);
                            isMarked = true;
                        } else {
                            isMarked = false;
                        }
                    }
                    case ';' -> {
                        if (isMarked) {
                            isMarked = false;
                            System.out.print("(c)");
                        } else {
                            System.out.print((char) c);
                        }
                    }
                    case ' ' -> {
                        if (isMarked) {
                            isMarked = false;
                            f.reset();
                            System.out.print("&");
                        } else {
                            System.out.print((char) c);
                        }
                    }
                    default -> {
                        if (!isMarked) {
                            System.out.print((char) c);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("I/O Error: " + e);
        }
    }
}
