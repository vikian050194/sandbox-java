package sandbox.concurrent;

import java.util.concurrent.Semaphore;

public class ProducerConsumerDemo {

    public static void main(String[] args) {
        var q = new Q();

        new Thread(new Consumer(q), "Consumer").start();
        new Thread(new Producer(q), "Producer").start();
    }
}

class Q {

    int n = 0;

    static Semaphore semaphoreConsumer = new Semaphore(0);
    static Semaphore semaphoreProducer = new Semaphore(1);

    void get() {
        try {
            semaphoreConsumer.acquire();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        }

        System.out.println("Got: " + n);
        semaphoreProducer.release();
    }

    void put(int n) {
        try {
            semaphoreProducer.acquire();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        }

        this.n = n;
        System.out.println("Put: " + n);
        semaphoreConsumer.release();

    }
}

class Producer implements Runnable {

    Q q;

    public Producer(Q q) {
        this.q = q;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            q.put(i);
        }
    }

}

class Consumer implements Runnable {

    Q q;

    public Consumer(Q q) {
        this.q = q;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            q.get();
        }
    }

}
