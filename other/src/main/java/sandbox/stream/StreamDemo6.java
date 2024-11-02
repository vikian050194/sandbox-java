package sandbox.stream;

import java.util.ArrayList;

public class StreamDemo6 {

    public static void main(String[] args) {
        var doubleList = new ArrayList<Double>();
        doubleList.add(1.1);
        doubleList.add(3.6);
        doubleList.add(9.2);
        doubleList.add(4.7);
        doubleList.add(12.1);
        doubleList.add(5.0);

        System.out.println(String.format("Original list: %s", doubleList));

        var intStream = doubleList.stream().mapToInt((d) -> (int) Math.ceil(d));

        System.out.print("Int values: ");
        intStream.forEach((n) -> System.out.print(String.format("%d ", n)));

    }
}
