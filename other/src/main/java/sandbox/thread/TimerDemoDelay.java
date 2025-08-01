package sandbox.thread;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemoDelay {

    public static void main(String[] args) {
        var task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("alarm");
                System.exit(0);
            }
        };
        var timer = new Timer();
        timer.schedule(task, 2000);
    }
}
