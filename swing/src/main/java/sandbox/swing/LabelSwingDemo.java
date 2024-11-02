package sandbox.swing;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class LabelSwingDemo {

    public LabelSwingDemo() {
        String title = "A Simple Swing Application";
        String msg = "Hello, World!";

        JFrame frame = new JFrame(title);

        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel(msg);

        frame.add(label);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LabelSwingDemo::new);
    }
}
