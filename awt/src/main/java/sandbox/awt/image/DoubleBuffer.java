package sandbox.awt.image;

import java.awt.*;
import java.awt.event.*;

public class DoubleBuffer extends Frame {

    int gap = 3;
    int mx;
    int my;
    boolean flicker = true;
    Image buffer = null;
    int w = 400;
    int h = 400;

    public DoubleBuffer() {
        addMouseMotionListener(new MouseMotionAdapter() {
            void handleMouseEvent(MouseEvent me, boolean flickerNew) {
                mx = me.getX();
                my = me.getY();
                flicker = flickerNew;
                repaint();
            }

            @Override
            public void mouseDragged(MouseEvent me) {
                handleMouseEvent(me, false);
            }

            @Override
            public void mouseMoved(MouseEvent me) {
                handleMouseEvent(me, true);
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
        Graphics screengc = null;

        if (!flicker) {
            screengc = g;
            g = buffer.getGraphics();
        }

        g.setColor(Color.blue);
        g.fillRect(0, 0, w, h);
        g.setColor(Color.red);
        for (int i = 0; i < w; i++) {
            g.drawLine(i, 0, w - i, h);
        }
        for (int i = 0; i < h; i++) {
            g.drawLine(0, i, w, h - i);
        }

        g.setColor(Color.black);
        g.drawString("Press mouse button to double buffer", 10, h / 2);

        g.setColor(Color.yellow);
        g.fillOval(mx - gap, my - gap, gap * 2 - 1, gap * 2 - 1);

        if (!flicker) {
            screengc.drawImage(buffer, 0, 0, null);
        }
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    public static void main(String[] args) {
        var appwin = new DoubleBuffer();

        appwin.setSize(new Dimension(400, 400));
        appwin.setTitle("DoubleBuffer");
        appwin.setVisible(true);

        appwin.buffer = appwin.createImage(appwin.w, appwin.h);
    }
}
