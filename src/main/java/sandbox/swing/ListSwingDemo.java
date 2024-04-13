package sandbox.swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public class ListSwingDemo {

    String[] cities = {"New York", "Chicago", "Houston",
        "Denver", "Los Angeles", "Seattle",
        "London", "Paris", "New Delhi",
        "Hong Kong", "Tokyo", "Sydney"};

    public ListSwingDemo() {
        String title = "List Demo Application";

        JFrame frame = new JFrame(title);
        frame.setLayout(new FlowLayout());
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var list = new JList<String>(cities);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        var pane = new JScrollPane(list);
        pane.setPreferredSize(new Dimension(120, 90));

        var label = new JLabel("Choose a City");

        list.addListSelectionListener((le) -> {
            var idx = list.getSelectedIndex();

            if (idx != -1) {
                label.setText(String.format("Current selection: %s", cities[idx]));
            } else {
                label.setText("Choose a City");
            }
        });

        frame.add(pane);
        frame.add(label);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ListSwingDemo::new);
    }
}
