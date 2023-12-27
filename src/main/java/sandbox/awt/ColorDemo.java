package sandbox.awt;

import java.awt.*;
import java.awt.event.*;

public class ColorDemo extends Frame {

    String msg = "";

    public ColorDemo() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        var c1 = new Color(255, 100, 100);
        var c2 = new Color(100, 255, 100);
        var c3 = new Color(100, 100, 255);

        g.setColor(c1);
        g.drawLine(20, 40, 100, 100);
        g.drawLine(20, 100, 100, 20);

        g.setColor(c2);
        g.drawLine(40, 45, 250, 180);
        g.drawLine(75, 90, 400, 400);

        g.setColor(c3);
        g.drawLine(20, 150, 400, 180);
        g.drawLine(25, 290, 80, 19);

        g.setColor(Color.RED);
        g.drawOval(20, 40, 50, 50);
        g.fillOval(70, 90, 140, 100);

        g.setColor(Color.BLUE);
        g.drawLine(190, 40, 90, 60);
        g.drawLine(40, 40, 55, 50);

        g.setColor(Color.CYAN);
        g.fillRect(100, 40, 60, 70);
        g.drawRoundRect(190, 40, 60, 60, 15, 15);
    }

    public static void main(String[] args) {
        var appwin = new ColorDemo();

        appwin.setSize(new Dimension(340, 260));
        appwin.setTitle("ColorDemo");
        appwin.setVisible(true);
    }
}
