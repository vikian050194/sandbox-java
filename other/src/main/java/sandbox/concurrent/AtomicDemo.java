package sandbox.concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class AtomicDemo {

    public static void main(String[] args) {
        var lock = new ReentrantLock();

        new Thread(new AtomicDemoThread("A")).start();
        new Thread(new AtomicDemoThread("B")).start();
        new Thread(new AtomicDemoThread("C")).start();
    }
}

class AtomicDemoShared {

    static AtomicInteger count = new AtomicInteger(0);
}

class AtomicDemoThread implements Runnable {

    String name;

    public AtomicDemoThread(String n) {
        name = n;
    }

    @Override
    public void run() {
        System.out.println("Starting " + name);

        for (int i = 0; i <= 3; i++) {
            System.out.println(String.format("%s got: %d", name, AtomicDemoShared.count.getAndSet(i)));
        }
    }

}
