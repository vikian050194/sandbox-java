package sandbox.scanner;

import java.util.*;
import java.io.*;

public class AvgFile {

    public static void main(String[] args) throws IOException {
        int count = 0;
        double sum = 0.0;

        // Write output to file
        var fout = new FileWriter("test.txt");
        fout.write("2 3.4 5 6 7.4 9.1 10.5 done");
        fout.close();
        
        var fin = new FileReader("test.txt");
        
        var src = new Scanner(fin);
        
        while (src.hasNext()) {
            if (src.hasNextDouble()) {
                sum += src.nextDouble();
                count++;
            } else {
                String str = src.next();
                if (str.equals("done")) {
                    break;
                } else {
                    System.out.println("Data format error.");
                    return;
                }
            }
        }

        src.close();
        System.out.println("Average is " + sum / count);
    }
}
