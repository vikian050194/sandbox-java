package sandbox.awt;

import java.awt.*;
import java.awt.event.*;

public class TextAreaDemo extends Frame implements ActionListener {

    public TextAreaDemo() {
        setLayout(new FlowLayout());

        var val = """
        Lorem ipsum dolor sit amet, consectetur adipiscing elit,
        sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
        Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris
        nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
        reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
        pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
        culpa qui officia deserunt mollit anim id est laborum.""";

        var text = new TextArea(val, 10, 30);

        add(text);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        var appwin = new TextAreaDemo();

        appwin.setSize(new Dimension(300, 220));
        appwin.setTitle("TextAreaDemo");
        appwin.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        repaint();
    }
}
