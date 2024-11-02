package sandbox.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleExecutor {

    public static void main(String[] args) {
        var latch = new CountDownLatch(5);
        var latch2 = new CountDownLatch(5);
        var latch3 = new CountDownLatch(5);
        var latch4 = new CountDownLatch(5);
        var executor = Executors.newFixedThreadPool(2);

        System.out.println("Starting...");

        executor.execute(new SimpleExecutorThread(latch, "A"));
        executor.execute(new SimpleExecutorThread(latch2, "B"));
        executor.execute(new SimpleExecutorThread(latch3, "C"));
        executor.execute(new SimpleExecutorThread(latch4, "D"));

        try {
            latch.await();
            latch2.await();
            latch3.await();
            latch4.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(SimpleExecutor.class.getName()).log(Level.SEVERE, null, ex);
        }

        executor.shutdown();

        System.out.println("Done");
    }
}

class SimpleExecutorThread implements Runnable {

    CountDownLatch latch;
    String name;

    public SimpleExecutorThread(CountDownLatch l, String n) {
        latch = l;
        name = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(String.format("%s: %d", name, i));
            latch.countDown();
        }
    }

}
