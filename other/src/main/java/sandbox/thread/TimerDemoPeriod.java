package sandbox.thread;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemoPeriod {

    public static void main(String[] args) {
        var task = new TimerTask() {
            @Override
            public void run() {
                System.out.println(System.currentTimeMillis());
            }
        };
        var timer = new Timer();
        timer.schedule(task, 0, 1000);
    }
}
