package sandbox.awt;

import java.awt.*;
import java.awt.event.*;

public class MouseEventDemo extends Frame implements MouseListener, MouseMotionListener {

    String msg = "";
    int mouseX = 0;
    int mouseY = 0;

    public MouseEventDemo() {
        addMouseListener(this);
        addMouseMotionListener(this);
        addWindowListener(new MyWindowAdapterMED());
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        msg += " -- click received";
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        mouseX = 100;
        mouseY = 100;
        msg = "Mouse entered";
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent me) {
        mouseX = 100;
        mouseY = 100;
        msg = "Mouse exited";
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent me) {
        mouseX = me.getX();
        mouseY = me.getY();
        msg = "Button pressed";
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        mouseX = me.getX();
        mouseY = me.getY();
        msg = "Button released";
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        mouseX = me.getX();
        mouseY = me.getY();
        msg = String.format("* mouse at %d, %d", mouseX, mouseY);
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        msg = String.format("Moving mouse at %d, %d", me.getX(), me.getY());
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, mouseX, mouseY);
    }

    public static void main(String[] args) {
        var appwin = new MouseEventDemo();

        appwin.setSize(new Dimension(300, 300));
        appwin.setTitle("MouseEventDemo");
        appwin.setVisible(true);
    }
}

class MyWindowAdapterMED extends WindowAdapter {

    @Override
    public void windowClosing(WindowEvent we) {
        System.exit(0);
    }
}
