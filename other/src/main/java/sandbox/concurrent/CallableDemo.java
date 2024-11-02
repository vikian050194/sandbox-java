package sandbox.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CallableDemo {

    public static void main(String[] args) {
        var executor = Executors.newFixedThreadPool(3);

        System.out.println("Starting...");

        var f = executor.submit(new Sum(10));
        var f2 = executor.submit(new Hypot(3, 4));
        var f3 = executor.submit(new Factorial(5));

        try {
            System.out.println(f.get());
            System.out.println(f2.get());
            System.out.println(f3.get());
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(CallableDemo.class.getName()).log(Level.SEVERE, null, ex);
        }

        executor.shutdown();

        System.out.println("Done");
    }
}

class Sum implements Callable<Integer> {

    int stop;

    public Sum(int v) {
        stop = v;
    }

    @Override
    public Integer call() {
        int sum = 0;

        for (int i = 1; i <= stop; i++) {
            sum += i;
        }

        return sum;
    }

}

class Hypot implements Callable<Double> {

    double a;
    double b;

    public Hypot(double x, double y) {
        a = x;
        b = y;
    }

    @Override
    public Double call() {
        return Math.sqrt((a * a) + (b * b));
    }

}

class Factorial implements Callable<Integer> {

    int stop;

    public Factorial(int v) {
        stop = v;
    }

    @Override
    public Integer call() {
        int fact = 1;

        for (int i = 1; i <= stop; i++) {
            fact *= i;
        }

        return fact;
    }

}
