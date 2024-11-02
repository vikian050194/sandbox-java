package sandbox.concurrent;

import java.util.concurrent.Phaser;
import java.util.logging.Level;
import java.util.logging.Logger;

class CustomPhaser extends Phaser {

    int numberOfPhases;

    CustomPhaser(int parties, int phaseCount) {
        super(parties);
        numberOfPhases = phaseCount - 1;
    }

    @Override
    protected boolean onAdvance(int phase, int registredParties) {
        System.out.println(String.format("Phase %d is completed", phase));

        if (phase == numberOfPhases || registredParties == 0) {
            return true;
        }

        return false;
    }
}

public class PhaserDemo2 {

    public static void main(String[] args) {
        var phaser = new CustomPhaser(1, 4);

        System.out.println("Starting...");

        new Thread(new PhaserDemo2Thread(phaser, "A")).start();
        new Thread(new PhaserDemo2Thread(phaser, "B")).start();
        new Thread(new PhaserDemo2Thread(phaser, "C")).start();

        while (!phaser.isTerminated()) {
            phaser.arriveAndAwaitAdvance();
        }

        System.out.println("Done");
    }
}

class PhaserDemo2Thread implements Runnable {

    Phaser phaser;
    String name;

    public PhaserDemo2Thread(Phaser p, String n) {
        phaser = p;
        name = n;

        phaser.register();
    }

    @Override
    public void run() {

        while (!phaser.isTerminated()) {
            System.out.println(String.format("Thread %s is beginning phase %d", name, phaser.getPhase()));
            phaser.arriveAndAwaitAdvance();

            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(PhaserDemoThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
