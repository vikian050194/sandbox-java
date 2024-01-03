package sandbox.awt.controls;

import java.awt.*;
import java.awt.event.*;

public class ScrollBarDemo extends Frame implements AdjustmentListener {

    String msg = "";
    Scrollbar vertical;
    Scrollbar horizontal;

    public ScrollBarDemo() {
        setLayout(new FlowLayout());

        vertical = new Scrollbar(Scrollbar.VERTICAL, 0, 1, 0, 200);
        vertical.setPreferredSize(new Dimension(20, 100));
        horizontal = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 100);
        horizontal.setPreferredSize(new Dimension(100, 20));

        add(vertical);
        add(horizontal);

        vertical.addAdjustmentListener(this);
        horizontal.addAdjustmentListener(this);

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                int x = me.getX();
                int y = me.getY();
                vertical.setValue(y);
                horizontal.setValue(x);
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
        g.drawString(String.format("v: %d, h: %d", vertical.getValue(), horizontal.getValue()), 20, 160);
        g.drawString("*", horizontal.getValue(), vertical.getValue());
    }

    public static void main(String[] args) {
        var appwin = new ScrollBarDemo();

        appwin.setSize(new Dimension(300, 300));
        appwin.setTitle("ScrollBarDemo");
        appwin.setVisible(true);
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent ae) {
        repaint();
    }
}
