package sandbox.thread;

public class Await {

    static volatile int count;

    public static void main(String[] args) {
        Runnable rw = () -> {
            var currentThread = Thread.currentThread();
            System.out.printf("%s has entered runnable and is waiting%n", currentThread.getName());
            synchronized (Await.class) {
                count++;
                try {
                    Thread.sleep(2000);
                    while (count < 3) {
                        Await.class.wait();
                    }
                } catch (InterruptedException ie) {

                }
            }
            System.out.printf("%s has woken up and is terminating%n", currentThread.getName());
        };
        var ta = new Thread(rw);
        var tb = new Thread(rw);
        var tc = new Thread(rw);
        ta.start();
        tb.start();
        tc.start();
        Runnable rn = () -> {
            try {
                while (count < 3) {
                    Thread.sleep(100);
                }
                synchronized (Await.class) {
                    Await.class.notifyAll();
                }
            } catch (InterruptedException ie) {

            }
        };
        var t = new Thread(rn);
        t.start();
    }
}
