package sandbox.swing;

import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class ComboBoxSwingDemo {

    String[] cities = {"New York", "Chicago", "Houston",
        "Denver", "Los Angeles", "Seattle",
        "London", "Paris", "New Delhi",
        "Hong Kong", "Tokyo", "Sydney"};

    public ComboBoxSwingDemo() {
        String title = "ComboBox Demo Application";

        JFrame frame = new JFrame(title);
        frame.setLayout(new FlowLayout());
        frame.setSize(200, 120);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var combo = new JComboBox<String>(cities);

        var label = new JLabel("Choose a City");

        combo.addActionListener((ae) -> {
            var s = combo.getSelectedItem();
            label.setText(String.format("Current selection: %s", s));
        });

        frame.add(combo);
        frame.add(label);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ComboBoxSwingDemo::new);
    }
}
