package sandbox.awt.controls;

import java.awt.*;
import java.awt.event.*;

public class ChoiceDemo extends Frame implements ItemListener {

    Choice os;
    Choice browser;

    public ChoiceDemo() {
        setLayout(new FlowLayout());

        os = new Choice();
        browser = new Choice();

        os.add("Windows");
        os.add("Android");
        os.add("Linux");
        os.add("Mac OS");

        browser.add("Edge");
        browser.add("Firefox");
        browser.add("Chrome");

        add(os);
        add(browser);

        os.addItemListener(this);
        browser.addItemListener(this);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        var appwin = new ChoiceDemo();

        appwin.setSize(new Dimension(300, 300));
        appwin.setTitle("ChoiceDemo");
        appwin.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(String.format("Current OS: %s", os.getSelectedItem()), 20, 120);
        g.drawString(String.format("Current browser: %s", browser.getSelectedItem()), 20, 140);
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        repaint();
    }
}
