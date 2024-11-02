package sandbox.concurrent;

import java.util.concurrent.Exchanger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExchangerDemo {

    public static void main(String[] args) {
        var ex = new Exchanger<String>();

        new Thread(new UseString(ex)).start();
        new Thread(new MakeString(ex)).start();
    }
}

class MakeString implements Runnable {

    Exchanger<String> ex;
    String str;

    public MakeString(Exchanger<String> ex) {
        this.ex = ex;
        str = new String();
    }

    @Override
    public void run() {
        var ch = 'A';

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                str += ch++;
            }

            try {
                str = ex.exchange(str);
            } catch (InterruptedException ex) {
                Logger.getLogger(MakeString.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

class UseString implements Runnable {

    Exchanger<String> ex;
    String str;

    public UseString(Exchanger<String> ex) {
        this.ex = ex;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                str = ex.exchange(new String());
                System.out.println("Got: " + str);
            } catch (InterruptedException ex) {
                Logger.getLogger(UseString.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
