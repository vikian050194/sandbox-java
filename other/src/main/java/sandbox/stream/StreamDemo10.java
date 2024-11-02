package sandbox.stream;

import java.util.ArrayList;

public class StreamDemo10 {

    public static void main(String[] args) {
        var strList = new ArrayList<String>();
        strList.add("Alpha");
        strList.add("Beta");
        strList.add("Gamma");
        strList.add("Delta");
        strList.add("Phi");
        strList.add("Omega");

        System.out.println(String.format("Original list: %s", strList));

        var strStream = strList.stream();

        var strSpl = strStream.spliterator();
        var strSlp2 = strSpl.trySplit();

        if (strSlp2 != null) {
            strSlp2.forEachRemaining((n) -> System.out.println(n));
        }

        System.out.println("Next spliterator");

        strSpl.forEachRemaining((n) -> System.out.println(n));

    }
}
