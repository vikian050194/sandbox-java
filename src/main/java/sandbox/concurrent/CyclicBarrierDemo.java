package sandbox.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        var cb = new CyclicBarrier(3, new CyclicBarrierDemoAction());

        System.out.println("Starting...");

        new Thread(new CyclicBarrierDemoThread(cb, "A")).start();
        new Thread(new CyclicBarrierDemoThread(cb, "B")).start();
        new Thread(new CyclicBarrierDemoThread(cb, "C")).start();
        new Thread(new CyclicBarrierDemoThread(cb, "X")).start();
        new Thread(new CyclicBarrierDemoThread(cb, "Y")).start();
        new Thread(new CyclicBarrierDemoThread(cb, "Z")).start();

    }
}

class CyclicBarrierDemoThread implements Runnable {

    CyclicBarrier cb;
    String name;

    public CyclicBarrierDemoThread(CyclicBarrier cb, String name) {
        this.cb = cb;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name);

        try {
            cb.await();
        } catch (InterruptedException | BrokenBarrierException ex) {
            Logger.getLogger(CyclicBarrierDemoThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

class CyclicBarrierDemoAction implements Runnable {

    @Override
    public void run() {
        System.out.println("Barrier is reached!");
    }

}
