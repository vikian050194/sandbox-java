package sandbox.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CountDownLatchDemo {

    public static void main(String[] args) {
        var latch = new CountDownLatch(5);

        System.out.println("Starting...");

        new Thread(new CountDownLatchDemoThread(latch)).start();

        try {
            latch.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(CountDownLatchDemo.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Done");
    }
}

class CountDownLatchDemoThread implements Runnable {

    CountDownLatch latch;

    public CountDownLatchDemoThread(CountDownLatch l) {
        latch = l;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            latch.countDown();
        }
    }

}
