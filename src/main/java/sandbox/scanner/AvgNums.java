package sandbox.scanner;

import java.util.*;

public class AvgNums {

    public static void main(String[] args) {
        int count = 0;
        double sum = 0.0;

        try (var conin = new Scanner(System.in)) {
            System.out.println("Enter numbers to average");

            while (conin.hasNext()) {
                if (conin.hasNextDouble()) {
                    sum += conin.nextDouble();
                    count++;
                } else {
                    String str = conin.next();
                    if (str.equals("done")) {
                        break;
                    } else {
                        System.out.println("Data format error.");
                        return;
                    }
                }
            }
        }

        System.out.println("Average is " + sum / count);
    }
}
