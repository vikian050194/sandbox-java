package sandbox.awt.controls;

import java.awt.*;
import java.awt.event.*;

public class LabelDemo extends Frame {

    String msg = "Hello, World!";

    public LabelDemo() {
        setLayout(new FlowLayout());

        var one = new Label("one");
        var two = new Label("two");
        var three = new Label("three");

        add(one);
        add(two);
        add(three);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        var appwin = new LabelDemo();

        appwin.setSize(new Dimension(300, 100));
        appwin.setTitle("LabelDemo");
        appwin.setVisible(true);
    }
}
