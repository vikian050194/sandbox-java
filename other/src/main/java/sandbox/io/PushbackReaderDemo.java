package sandbox.io;

import java.io.*;

public class PushbackReaderDemo {

    public static void main(String[] args) throws IOException {
        var source = "if (a == 4) a = 0;\n";

        var b = new char[source.length()];
        source.getChars(0, source.length(), b, 0);

        var in = new CharArrayReader(b);
        int c;

        try (var f = new PushbackReader(in)) {
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
