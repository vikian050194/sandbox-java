package sandbox.awt;

import java.awt.*;
import java.awt.event.*;

public class AnonymousInnerClassDemo extends Frame {

    String msg = "";

    public AnonymousInnerClassDemo() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                msg = "Button pressed";
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
        g.drawString(msg, 20, 80);
    }

    public static void main(String[] args) {
        var appwin = new AnonymousInnerClassDemo();

        appwin.setSize(new Dimension(300, 300));
        appwin.setTitle("AnonymousInnerClassDemo");
        appwin.setVisible(true);
    }
}
