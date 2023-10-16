package sandbox.io;

import java.io.*;

public class PushbackInputStreamDemo {

    public static void main(String[] args) throws IOException {
        var source = "if (a == 4) a = 0;\n";

        var b = source.getBytes();

        var in = new ByteArrayInputStream(b);
        int c;

        try (var f = new PushbackInputStream(in)) {
            while ((c = f.read()) != -1) {
                switch (c) {
                    case '=' -> {
                        if ((c = f.read()) == '=') {
                            System.out.print(".eq.");
                        } else {
                            System.out.print("<-");
                            f.unread(c);
                        }
                    }
                    default -> {
                        System.out.print((char) c);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("I/O Error: " + e);
        }
    }
}
