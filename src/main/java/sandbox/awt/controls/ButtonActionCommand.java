package sandbox.awt.controls;

import java.awt.*;
import java.awt.event.*;

public class ButtonActionCommand extends Frame implements ActionListener {

    enum Actions {
        YES,
        NO,
        MAYBE
    }

    String msg = "";
    Button[] buttons = new Button[3];

    public ButtonActionCommand() {
        setLayout(new FlowLayout());

        var yes = new Button("Yes");
        yes.setActionCommand(Actions.YES.toString());
        var no = new Button("No");
        no.setActionCommand(Actions.NO.toString());
        var maybe = new Button("Undecided");
        maybe.setActionCommand(Actions.MAYBE.toString());

        buttons[0] = (Button) add(yes);
        buttons[1] = (Button) add(no);
        buttons[2] = (Button) add(maybe);

        for (int i = 0; i < 3; i++) {
            buttons[i].addActionListener(this);
        }

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        var appwin = new ButtonActionCommand();

        appwin.setSize(new Dimension(300, 150));
        appwin.setTitle("ButtonList");
        appwin.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        for (int i = 0; i < 3; i++) {
            if (ae.getSource() == buttons[i]) {
                msg = "You pressed " + ae.getActionCommand();
            }
        }

        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, 20, 100);
    }
}
