package sandbox.concurrent;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SemaphoreDemo {

    public static void main(String[] args) {
        var sem = new Semaphore(1);

        new Thread(new IncrementThread(sem, "A")).start();
        new Thread(new DecrementThread(sem, "B")).start();
    }
}

class Shared {

    static int count = 0;
}

class IncrementThread implements Runnable {

    Semaphore sem;
    String name;

    public IncrementThread(Semaphore s, String n) {
        sem = s;
        name = n;
    }

    @Override
    public void run() {
        System.out.println("Starting " + name);

        try {
            System.out.println(name + " is waiting for a permit");
            sem.acquire();
            System.out.println(name + " gets a permit");

            for (int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + ": " + Shared.count);

                Thread.sleep(10);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(SemaphoreDemo.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(name + " releases the permit");
        sem.release();
    }

}

class DecrementThread implements Runnable {

    Semaphore sem;
    String name;

    public DecrementThread(Semaphore s, String n) {
        sem = s;
        name = n;
    }

    @Override
    public void run() {
        System.out.println("Starting " + name);

        try {
            System.out.println(name + " is waiting for a permit");
            sem.acquire();
            System.out.println(name + " gets a permit");

            for (int i = 0; i < 5; i++) {
                Shared.count--;
                System.out.println(name + ": " + Shared.count);

                Thread.sleep(10);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(SemaphoreDemo.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(name + " releases the permit");
        sem.release();
    }

}
