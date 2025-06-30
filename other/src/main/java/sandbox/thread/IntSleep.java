package sandbox.thread;

public class IntSleep {

    public static void main(String[] args) {
        Runnable r = () -> {
            while (!Thread.interrupted()) {
                System.out.println("Hello");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    break;
                }
            }

            System.out.println("interrupted");
        };

        var thread = new Thread(r);
        thread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {

        }

        thread.interrupt();
    }
}
