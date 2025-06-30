package sandbox.thread;

public class PC {

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        var s = new Shared();
        new Producer(s).start();
        new Consumer(s).start();
    }
}

class Shared {

    private char c;
    private volatile boolean writable = true;

    synchronized void setSharedChar(char c) {
        while (!writable) {
            try {
                wait();
            } catch (InterruptedException ie) {

            }
        }
        this.c = c;
        writable = false;
        notify();
    }

    synchronized char getSharedChar() {
        while (writable) {
            try {
                wait();
            } catch (InterruptedException ie) {

            }
        }
        writable = true;
        notify();
        return c;
    }
}

class Producer extends Thread {

    private final Shared s;

    public Producer(Shared s) {
        this.s = s;
    }

    @Override
    public void run() {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
//            synchronized (s) {
            s.setSharedChar(ch);
            System.out.println(ch + " produced by producer.");
//            }
        }
    }
}

class Consumer extends Thread {

    private final Shared s;

    public Consumer(Shared s) {
        this.s = s;
    }

    @Override
    public void run() {
        char ch;
        do {
//            synchronized (s) {
            ch = s.getSharedChar();
            System.out.println(ch + " consumed by consumer.");
//            }

        } while (ch != 'Z');
    }
}
