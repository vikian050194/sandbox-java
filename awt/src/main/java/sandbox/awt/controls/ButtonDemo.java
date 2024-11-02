package sandbox.awt.controls;

import java.awt.*;
import java.awt.event.*;

public class ButtonDemo extends Frame implements ActionListener {

    String msg = "";
    Button yes;
    Button no;
    Button maybe;

    public ButtonDemo() {
        setLayout(new FlowLayout());

        yes = new Button("Yes");
        no = new Button("No");
        maybe = new Button("Undecided");

        add(yes);
        add(no);
        add(maybe);

        yes.addActionListener(this);
        no.addActionListener(this);
        maybe.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        var appwin = new ButtonDemo();

        appwin.setSize(new Dimension(300, 150));
        appwin.setTitle("ButtonDemo");
        appwin.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        var str = ae.getActionCommand();
        switch (str) {
            case "Yes":
                msg = "You pressed Yes.";
                break;
            case "No":
                msg = "You pressed No.";
                break;
            case "Undecided":
                msg = "You pressed Undecided.";
                break;
            default:
                throw new AssertionError();
        }

        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, 20, 100);
    }
}
