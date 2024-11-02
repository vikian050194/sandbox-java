package sandbox.stream;

import java.util.ArrayList;

public class StreamDemo9 {

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

        while (strSpl.tryAdvance((n) -> System.out.println(n))) {
        }
    }
}
