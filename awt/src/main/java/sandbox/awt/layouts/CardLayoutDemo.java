package sandbox.awt.layouts;

import java.awt.*;
import java.awt.event.*;

public class CardLayoutDemo extends Frame {

    Checkbox win10;
    Checkbox win8;
    Checkbox win7;
    Checkbox androind;
    Checkbox linux;
    Checkbox mac;
    Panel cards;
    CardLayout layout;
    Button win;
    Button other;

    public CardLayoutDemo() {
        setLayout(new FlowLayout());

        win = new Button("Windows");
        other = new Button("Other");
        add(win);
        add(other);

        layout = new CardLayout();
        cards = new Panel();
        cards.setLayout(layout);

        win7 = new Checkbox("Windows 7", true);
        win8 = new Checkbox("Windows 8");
        win10 = new Checkbox("Windows 10");
        androind = new Checkbox("Android");
        linux = new Checkbox("Linux");
        mac = new Checkbox("Mac OS");

        var winPanel = new Panel();
        winPanel.add(win7);
        winPanel.add(win8);
        winPanel.add(win10);

        var otherPanel = new Panel();
        otherPanel.add(androind);
        otherPanel.add(linux);
        otherPanel.add(mac);

        cards.add(winPanel, "Windows");
        cards.add(otherPanel, "Other");

        add(cards);

        win.addActionListener((ae) -> layout.show(cards, "Windows"));
        other.addActionListener((ae) -> layout.show(cards, "Other"));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                layout.next(cards);
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        var appwin = new CardLayoutDemo();

        appwin.setSize(new Dimension(300, 300));
        appwin.setTitle("CardLayoutDemo");
        appwin.setVisible(true);
    }
}
