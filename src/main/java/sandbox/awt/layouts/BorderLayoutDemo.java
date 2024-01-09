package sandbox.awt.layouts;

import java.awt.*;
import java.awt.event.*;

public class BorderLayoutDemo extends Frame {

    public BorderLayoutDemo() {
//        setLayout(new BorderLayout()); // default layout manager so this call could be skipped

        add(new Button("Top button"), BorderLayout.NORTH);
        add(new Label("Footer label"), BorderLayout.SOUTH);
        add(new Button("Right button"), BorderLayout.EAST);
        add(new Button("Left"), BorderLayout.WEST);

        var msg = "Hello, World!";
        add(new TextArea(msg), BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        var appwin = new BorderLayoutDemo();

        appwin.setSize(new Dimension(300, 300));
        appwin.setTitle("BorderLayoutDemo");
        appwin.setVisible(true);
    }
}
