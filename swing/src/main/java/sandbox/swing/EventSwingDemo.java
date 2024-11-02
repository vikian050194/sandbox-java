package sandbox.swing;

import java.awt.*;
import javax.swing.*;

public class EventSwingDemo {

    JLabel label;

    public EventSwingDemo() {
        String title = "An Event Example";
        String msg = "Press a button";

        JFrame frame = new JFrame(title);

        frame.setLayout(new FlowLayout());

        frame.setSize(250, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton buttonA = new JButton("Alpha");
        JButton buttonB = new JButton("Beta");

        buttonA.addActionListener((ae) -> {
            label.setText("Alpha is pressed");
        });

        buttonB.addActionListener((ae) -> {
            label.setText("Beta is pressed");
        });

        frame.add(buttonA);
        frame.add(buttonB);

        label = new JLabel(msg);
        frame.add(label);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EventSwingDemo::new);
    }
}
