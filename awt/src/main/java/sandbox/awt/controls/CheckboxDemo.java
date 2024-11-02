package sandbox.awt.controls;

import java.awt.*;
import java.awt.event.*;

public class CheckboxDemo extends Frame implements ItemListener {

    String msg = "";
    Checkbox windows;
    Checkbox android;
    Checkbox linux;
    Checkbox mac;

    public CheckboxDemo() {
        setLayout(new FlowLayout());

        windows = new Checkbox("Windows");
        android = new Checkbox("Android");
        linux = new Checkbox("Linux", true);
        mac = new Checkbox("Mac OS");

        add(windows);
        add(android);
        add(linux);
        add(mac);

        windows.addItemListener(this);
        android.addItemListener(this);
        linux.addItemListener(this);
        mac.addItemListener(this);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        var appwin = new CheckboxDemo();

        appwin.setSize(new Dimension(300, 300));
        appwin.setTitle("CheckboxDemo");
        appwin.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        g.drawString("Current state:", 20, 120);
        g.drawString(String.format("Windows: %s", windows.getState()), 20, 140);
        g.drawString(String.format("Android: %s", android.getState()), 20, 160);
        g.drawString(String.format("Linux: %s", linux.getState()), 20, 180);
        g.drawString(String.format("Mac OS: %s", mac.getState()), 20, 200);
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        repaint();
    }
}
