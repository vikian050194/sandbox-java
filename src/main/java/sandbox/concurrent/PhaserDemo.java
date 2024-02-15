package sandbox.concurrent;

import java.util.concurrent.Phaser;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhaserDemo {

    public static void main(String[] args) {
        var phaser = new Phaser(1);
        int currentPhase;

        System.out.println("Starting...");

        new Thread(new PhaserDemoThread(phaser, "A")).start();
        new Thread(new PhaserDemoThread(phaser, "B")).start();
        new Thread(new PhaserDemoThread(phaser, "C")).start();

        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println(String.format("Phase %d is complete", currentPhase));

        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println(String.format("Phase %d is complete", currentPhase));

        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println(String.format("Phase %d is complete", currentPhase));

        phaser.arriveAndDeregister();

        if (phaser.isTerminated()) {
            System.out.println("Phaser was terminated");
        }

        System.out.println("Done");
    }
}

class PhaserDemoThread implements Runnable {

    Phaser phaser;
    String name;

    public PhaserDemoThread(Phaser p, String n) {
        phaser = p;
        name = n;

        phaser.register();
    }

    @Override
    public void run() {
        System.out.println(String.format("Thread %s is beginning phase one", name));
        phaser.arriveAndAwaitAdvance();

        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(PhaserDemoThread.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(String.format("Thread %s is beginning phase two", name));
        phaser.arriveAndAwaitAdvance();

        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(PhaserDemoThread.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(String.format("Thread %s is beginning phase three", name));
        phaser.arriveAndDeregister();
    }

}
