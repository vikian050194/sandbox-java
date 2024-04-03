package sandbox.swing;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TextFieldSwingDemo {

    public TextFieldSwingDemo() {
        String title = "A TextField Swing Application";
        String msg = "Hello, World!";

        JFrame frame = new JFrame(title);

        frame.setLayout(new FlowLayout());

        frame.setSize(260, 120);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var textField = new JTextField(msg, 16);
        frame.add(textField);

        var label = new JLabel(msg);
        frame.add(label);

        textField.addActionListener((ae) -> {
            label.setText(textField.getText());
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TextFieldSwingDemo::new);
    }
}
