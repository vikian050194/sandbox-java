package sandbox.scanner;

import java.util.*;
import java.io.*;

public class ScanMixed {

    public static void main(String[] args) throws IOException {
        int i;
        double d;
        boolean b;
        String s;

        // Write output to file
        try (var fout = new FileWriter("test.txt")) {
            fout.write("Testing Scanner 10 12.2 one true two false");
        }

        var fin = new FileReader("test.txt");

        try (var src = new Scanner(fin)) {
            while (src.hasNext()) {
                if (src.hasNextInt()) {
                    i = src.nextInt();
                    System.out.println("int: " + i);
                } else if (src.hasNextDouble()) {
                    d = src.nextDouble();
                    System.out.println("double: " + d);
                } else if (src.hasNextBoolean()) {
                    b = src.nextBoolean();
                    System.out.println("boolean: " + b);
                } else {
                    s = src.next();
                    System.out.println("String: " + s);
                }
            }
        }
    }
}
