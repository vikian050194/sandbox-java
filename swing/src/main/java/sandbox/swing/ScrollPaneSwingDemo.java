package sandbox.swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class ScrollPaneSwingDemo {

    public ScrollPaneSwingDemo() {
        String title = "ScrollPane Demo Application";

        JFrame frame = new JFrame(title);

        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var pane = new JPanel();
        pane.setLayout(new GridLayout(20, 20));

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                pane.add(new JButton(String.format("Button %d", i * 20 + j)));
            }
        }

        frame.add(new JScrollPane(pane), BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ScrollPaneSwingDemo::new);
    }
}
