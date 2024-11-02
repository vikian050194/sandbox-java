package sandbox.stream;

import java.util.ArrayList;

public class StreamDemo {

    public static void main(String[] args) {
        var intList = new ArrayList<Integer>();
        intList.add(7);
        intList.add(18);
        intList.add(10);
        intList.add(24);
        intList.add(17);
        intList.add(5);

        System.out.println(String.format("Original list: %s", intList));

        var intStream = intList.stream();

        var optMin = intStream.min(Integer::compare);

        if (optMin.isPresent()) {
            System.out.println(String.format("Min value: %d", optMin.get()));
        }

        intStream = intList.stream();
        var optMax = intStream.max(Integer::compare);

        if (optMax.isPresent()) {
            System.out.println(String.format("Max value: %d", optMax.get()));
        }

        intStream = intList.stream();
        var sortedStream = intStream.sorted();
        System.out.print("Sorted stream: ");
        sortedStream.forEach((n) -> System.out.print(String.format("%d ", n)));
        System.out.println("");

        var oddStream = intList.stream().sorted().filter((n) -> (n % 2) == 1);
        System.out.print("Odd values: ");
        oddStream.forEach((n) -> System.out.print(String.format("%d ", n)));
        System.out.println("");

        var oddGreater5Stream = intList.stream().sorted().filter((n) -> (n % 2) == 1).filter((n) -> n > 5);
        System.out.print("Odd values greater than 5: ");
        oddGreater5Stream.forEach((n) -> System.out.print(String.format("%d ", n)));
        System.out.println("");

    }
}
