package sandbox.awt;

import java.awt.*;
import java.awt.event.*;

public class SimpleKey extends Frame implements KeyListener {

    String msg = "";
    String keyState = "";

    public SimpleKey() {
        addKeyListener(this);
        addWindowListener(new MyWindowAdapterSK());
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        keyState = "Key Down";
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        keyState = "Key Up";
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        msg += ke.getKeyChar();
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, 20, 100);
        g.drawString(keyState, 20, 50);
    }

    public static void main(String[] args) {
        var appwin = new SimpleKey();

        appwin.setSize(new Dimension(300, 300));
        appwin.setTitle("SimpleKey");
        appwin.setVisible(true);
    }
}

class MyWindowAdapterSK extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent we) {
            System.exit(0);
        }
    }
