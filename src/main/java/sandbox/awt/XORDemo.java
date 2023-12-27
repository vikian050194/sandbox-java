package sandbox.awt;

import java.awt.*;
import java.awt.event.*;

public class XORDemo extends Frame {

    int x = 100;
    int y = 100;

    public XORDemo() {
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent me) {
                x = me.getX() - 10;
                y = me.getY() - 10;
                repaint();
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(20, 40, 60, 70);

        g.setColor(Color.BLUE);
        g.fillRect(110, 40, 60, 70);

        g.setColor(Color.BLACK);
        g.fillRect(200, 40, 60, 70);

        g.setColor(Color.RED);
        g.fillRect(60, 120, 160, 110);

        g.setXORMode(Color.BLACK);
        g.drawLine(x - 10, y, x + 10, y);
        g.drawLine(x, y - 10, x, y + 10);
        g.setPaintMode();
    }

    public static void main(String[] args) {
        var appwin = new XORDemo();

        appwin.setSize(new Dimension(300, 260));
        appwin.setTitle("XOR Demo");
        appwin.setVisible(true);
    }
}
