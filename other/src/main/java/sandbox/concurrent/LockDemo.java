package sandbox.concurrent;

import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LockDemo {

    public static void main(String[] args) {
        var lock = new ReentrantLock();

        new Thread(new LockDemoThread(lock, "A")).start();
        new Thread(new LockDemoThread(lock, "B")).start();
    }
}

class LockDemoShared {

    static int count = 0;
}

class LockDemoThread implements Runnable {

    ReentrantLock lock;
    String name;

    public LockDemoThread(ReentrantLock l, String n) {
        lock = l;
        name = n;
    }

    @Override
    public void run() {
        System.out.println("Starting " + name);

        try {
            System.out.println(name + " is waiting to lock count");
            lock.lock();
            System.out.println(name + " is locked count");

            LockDemoShared.count++;
            System.out.println(name + ": " + LockDemoShared.count);

            System.out.println(name + " is sleeping");

            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(LockDemo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            System.out.println(name + " is unlocking count");
            lock.unlock();
        }
    }

}
