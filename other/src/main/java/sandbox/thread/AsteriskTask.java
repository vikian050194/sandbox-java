package sandbox.thread;

import java.util.Timer;
import java.util.TimerTask;

public class AsteriskTask {

    private static volatile InheritableThreadLocal<Integer> step = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        var task = new TimerTask() {
            @Override
            public void run() {
                if (step.get() >= 20) {
                    cancel();
                    System.exit(0);
                }

                for (var i = 0; i < 20 - Math.abs(step.get()); i++) {
                    System.out.print(" ");
                }

                System.out.println("*");

                step.set(step.get() + 1);
            }
        };

        step.set(-20);
        var timer = new Timer();
        timer.schedule(task, 0, 100);
    }
}
