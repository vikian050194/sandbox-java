package sandbox.swing;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class CheckBoxSwingDemo implements ItemListener {

    JLabel label;

    public CheckBoxSwingDemo() {
        String title = "CheckBox Demo Application";

        JFrame frame = new JFrame(title);
        frame.setLayout(new FlowLayout());

        frame.setSize(250, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var cb1 = new JCheckBox("C");
        cb1.addItemListener(this);
        frame.add(cb1);

        var cb2 = new JCheckBox("C++");
        cb2.addItemListener(this);
        frame.add(cb2);

        var cb3 = new JCheckBox("Java");
        cb3.addItemListener(this);
        frame.add(cb3);

        var cb4 = new JCheckBox("Perl");
        cb4.addItemListener(this);
        frame.add(cb4);

        label = new JLabel("Select language");
        frame.add(label);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CheckBoxSwingDemo::new);
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        var cb = (JCheckBox) ie.getItem();

        if (cb.isSelected()) {
            label.setText(String.format("%s is selected", cb.getText()));
        } else {
            label.setText(String.format("%s is cleared", cb.getText()));
        }
    }
}
