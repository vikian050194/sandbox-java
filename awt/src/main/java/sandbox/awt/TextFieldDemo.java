package sandbox.awt;

import java.awt.*;
import java.awt.event.*;

public class TextFieldDemo extends Frame implements ActionListener {

    TextField name;
    TextField password;

    public TextFieldDemo() {
        setLayout(new FlowLayout());

        var namep = new Label("Name: ", Label.RIGHT);
        var passwordp = new Label("Password: ", Label.RIGHT);

        name = new TextField(12);
        password = new TextField(8);

        password.setEchoChar('?');

        add(namep);
        add(name);
        add(passwordp);
        add(password);

        name.addActionListener(this);
        password.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(String.format("Name: %s", name.getText()), 20, 100);
        g.drawString(String.format("Selected text in name: %s", name.getSelectedText()), 20, 120);
        g.drawString(String.format("Password: %s", password.getText()), 20, 140);
    }

    public static void main(String[] args) {
        var appwin = new TextFieldDemo();

        appwin.setSize(new Dimension(380, 200));
        appwin.setTitle("TextFieldDemo");
        appwin.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        repaint();
    }
}
