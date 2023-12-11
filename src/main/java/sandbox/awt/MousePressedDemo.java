package sandbox.awt;

import java.awt.*;
import java.awt.event.*;

public class MousePressedDemo extends Frame {

    String msg = "";

    public MousePressedDemo() {
        addMouseListener(new MyMouseAdapter(this));
        addMouseMotionListener(new MyMouseAdapter(this));
        addWindowListener(new MyWindowAdapterMPD());
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, 20, 80);
    }

    public static void main(String[] args) {
        var appwin = new MousePressedDemo();

        appwin.setSize(new Dimension(300, 300));
        appwin.setTitle("MousePressedDemo");
        appwin.setVisible(true);
    }

    class MyMouseAdapter extends MouseAdapter {

        MousePressedDemo adapterDemo;

        public MyMouseAdapter(MousePressedDemo adapterDemo) {
            this.adapterDemo = adapterDemo;
        }

        @Override
        public void mousePressed(MouseEvent me) {
            adapterDemo.msg = "Button pressed";
            repaint();
        }
    }
}

class MyWindowAdapterMPD extends WindowAdapter {

    @Override
    public void windowClosing(WindowEvent we) {
        System.exit(0);
    }
}
