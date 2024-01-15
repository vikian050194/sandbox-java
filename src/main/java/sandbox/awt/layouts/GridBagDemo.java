package sandbox.awt.layouts;

import java.awt.*;
import java.awt.event.*;

public class GridBagDemo extends Frame implements ItemListener {

    Checkbox win;
    Checkbox androind;
    Checkbox linux;
    Checkbox mac;

    public GridBagDemo() {
        var layout = new GridBagLayout();
        var layoutConstraints = new GridBagConstraints();
        setLayout(layout);

        win = new Checkbox("Windows");
        androind = new Checkbox("Android");
        linux = new Checkbox("Linux", true);
        mac = new Checkbox("Mac OS");

        layoutConstraints.weightx = 1.0;
        layoutConstraints.ipadx = 200;
        layoutConstraints.insets = new Insets(0, 6, 0, 0);

        layoutConstraints.anchor = GridBagConstraints.NORTHEAST;

        layoutConstraints.gridwidth = GridBagConstraints.RELATIVE;
        layout.setConstraints(win, layoutConstraints);

        layoutConstraints.gridwidth = GridBagConstraints.REMAINDER;
        layout.setConstraints(androind, layoutConstraints);

        layoutConstraints.weighty = 1.0;

        layoutConstraints.gridwidth = GridBagConstraints.RELATIVE;
        layout.setConstraints(linux, layoutConstraints);

        layoutConstraints.gridwidth = GridBagConstraints.REMAINDER;
        layout.setConstraints(mac, layoutConstraints);

        add(win);
        add(androind);
        add(linux);
        add(mac);

        win.addItemListener(this);
        androind.addItemListener(this);
        linux.addItemListener(this);
        mac.addItemListener(this);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(String.format("Windows: %s", win.getState()), 20, 100);
        g.drawString(String.format("Android: %s", androind.getState()), 20, 120);
        g.drawString(String.format("Linux: %s", linux.getState()), 20, 140);
        g.drawString(String.format("Mac OS: %s", mac.getState()), 20, 160);
    }

    public static void main(String[] args) {
        var appwin = new GridBagDemo();

        appwin.setSize(new Dimension(300, 300));
        appwin.setTitle("GridBagDemo");
        appwin.setVisible(true);
    }
}
