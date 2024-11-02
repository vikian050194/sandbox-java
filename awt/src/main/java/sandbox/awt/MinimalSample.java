package sandbox.awt;

import java.awt.*;
import java.awt.event.*;

public class MinimalSample extends Frame {

    String msg = "Hello, World!";

    public MinimalSample() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, 20, 80);
    }

    public static void main(String[] args) {
        var appwin = new MinimalSample();

        appwin.setSize(new Dimension(300, 300));
        appwin.setTitle("MinimalSample");
        appwin.setVisible(true);
    }
}
