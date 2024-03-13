package sandbox.stream;

import java.util.ArrayList;

public class StreamDemo4 {

    public static void main(String[] args) {
        var doubleList = new ArrayList<Double>();
        doubleList.add(7.0);
        doubleList.add(18.0);
        doubleList.add(10.0);
        doubleList.add(24.0);
        doubleList.add(17.0);
        doubleList.add(5.0);

        System.out.println(String.format("Original list: %s", doubleList));

        var doubleStream = doubleList.stream();

        var sqrtStream = doubleStream.map((a) -> Math.sqrt(a));

        var productSqrt = sqrtStream.reduce(1.0, (acc, v) -> acc * v);

        System.out.println(String.format("Product as double: %f", productSqrt));

    }
}
