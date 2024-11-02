package sandbox.awt.controls;

import java.awt.*;
import java.awt.event.*;

public class CheckboxGroupDemo extends Frame implements ItemListener {

    String msg = "";
    Checkbox windows;
    Checkbox android;
    Checkbox linux;
    Checkbox mac;

    CheckboxGroup group;

    public CheckboxGroupDemo() {
        setLayout(new FlowLayout());

        group = new CheckboxGroup();

        windows = new Checkbox("Windows");
        android = new Checkbox("Android");
        linux = new Checkbox("Linux", group, true);
        mac = new Checkbox("Mac OS", group, false);

        windows.setCheckboxGroup(group);
        android.setCheckboxGroup(group);

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
        var appwin = new CheckboxGroupDemo();

        appwin.setSize(new Dimension(300, 300));
        appwin.setTitle("CheckboxGroupDemo");
        appwin.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(String.format("Current selection: %s", group.getSelectedCheckbox().getLabel()), 20, 120);
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        repaint();
    }
}
