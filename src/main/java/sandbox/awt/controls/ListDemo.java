package sandbox.awt.controls;

import java.awt.*;
import java.awt.event.*;

public class ListDemo extends Frame implements ActionListener {

    List os;
    List browser;

    public ListDemo() {
        setLayout(new FlowLayout());

        os = new List(4, true);
        browser = new List(4);

        os.add("Windows");
        os.add("Android");
        os.add("Linux");
        os.add("Mac OS");

        browser.add("Edge");
        browser.add("Firefox");
        browser.add("Chrome");

        os.select(0);
        browser.select(1);

        add(os);
        add(browser);

        os.addActionListener(this);
        browser.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        var appwin = new ListDemo();

        appwin.setSize(new Dimension(300, 300));
        appwin.setTitle("ListDemo");
        appwin.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(String.format("Current OS: %s", os.getSelectedItem()), 20, 150);
        g.drawString(String.format("Current browser: %s", browser.getSelectedItem()), 20, 170);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        repaint();
    }
}
