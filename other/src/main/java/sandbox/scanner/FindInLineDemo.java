package sandbox.scanner;

import java.util.*;

public class FindInLineDemo {

    public static void main(String[] args) {
        String instr = "Name: Tom Age: 28 ID: 77";

        try (var conin = new Scanner(instr)) {
            // Find and display age
            conin.findInLine("Age:");

            if (conin.hasNext()) {
                System.out.println(conin.next());
            } else {
                System.out.println("Error!``");
            }
        }
    }
}
