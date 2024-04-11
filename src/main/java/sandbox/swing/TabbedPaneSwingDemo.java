package sandbox.swing;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

class CitiesPanel extends JPanel {

    public CitiesPanel() {
        add(new JButton("New York"));
        add(new JButton("London"));
        add(new JButton("Hong Kong"));
        add(new JButton("Tokyo"));
    }
}

class ColorsPanel extends JPanel {

    public ColorsPanel() {
        add(new JCheckBox("Red"));
        add(new JCheckBox("Green"));
        add(new JCheckBox("Blue"));
    }
}

class FlavorsPanel extends JPanel {

    public FlavorsPanel() {
        var combo = new JComboBox<String>();
        combo.addItem("Vanilla");
        combo.addItem("Chocolate");
        combo.addItem("Strawberry");
        add(combo);
    }
}

public class TabbedPaneSwingDemo {

    public TabbedPaneSwingDemo() {
        String title = "TabbedPan Demo Application";

        JFrame frame = new JFrame(title);
        frame.setLayout(new FlowLayout());

        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var pane = new JTabbedPane();
        pane.addTab("Cities", new CitiesPanel());
        pane.addTab("Colors", new ColorsPanel());
        pane.addTab("Flavors", new FlavorsPanel());

        frame.add(pane);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TabbedPaneSwingDemo::new);
    }
}
