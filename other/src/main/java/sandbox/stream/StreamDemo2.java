package sandbox.stream;

import java.util.ArrayList;

public class StreamDemo2 {

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

        var productOptional = intStream.reduce((acc, v) -> acc * v);

        if (productOptional.isPresent()) {
            System.out.println(String.format("Product as Optional: %d", productOptional.get()));
        }

        intStream = intList.stream();
        var product = intStream.reduce(1, (acc, v) -> acc * v);

        System.out.println(String.format("Product as int: %d", product));

    }
}
