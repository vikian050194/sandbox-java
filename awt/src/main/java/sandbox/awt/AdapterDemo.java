package sandbox.awt;

import java.awt.*;
import java.awt.event.*;

public class AdapterDemo extends Frame {

    String msg = "";

    public AdapterDemo() {
        addMouseListener(new MyMouseAdapter(this));
        addMouseMotionListener(new MyMouseAdapter(this));
        addWindowListener(new MyWindowAdapterAD());
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, 20, 80);
    }

    public static void main(String[] args) {
        var appwin = new AdapterDemo();

        appwin.setSize(new Dimension(300, 300));
        appwin.setTitle("AdapterDemo");
        appwin.setVisible(true);
    }

    class MyMouseAdapter extends MouseAdapter {

        AdapterDemo adapterDemo;

        public MyMouseAdapter(AdapterDemo adapterDemo) {
            this.adapterDemo = adapterDemo;
        }

        @Override
        public void mouseClicked(MouseEvent me) {
            adapterDemo.msg = "Mouse clicked";
            repaint();
        }

        @Override
        public void mouseDragged(MouseEvent me) {
            adapterDemo.msg = "Mouse dragged";
            repaint();
        }
    }
}

class MyWindowAdapterAD extends WindowAdapter {

    @Override
    public void windowClosing(WindowEvent we) {
        System.exit(0);
    }
}
