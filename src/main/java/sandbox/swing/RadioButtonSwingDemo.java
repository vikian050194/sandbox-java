package sandbox.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class RadioButtonSwingDemo implements ActionListener {

    JLabel label;

    public RadioButtonSwingDemo() {
        String title = "RadioBUtton Demo Application";

        JFrame frame = new JFrame(title);
        frame.setLayout(new FlowLayout());

        frame.setSize(250, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var rb1 = new JRadioButton("C");
        rb1.addActionListener(this);
        frame.add(rb1);

        var rb2 = new JRadioButton("C++");
        rb2.addActionListener(this);
        frame.add(rb2);

        var rb3 = new JRadioButton("Java");
        rb3.addActionListener(this);
        frame.add(rb3);

        var rbg = new ButtonGroup();
        rbg.add(rb1);
        rbg.add(rb2);
        rbg.add(rb3);

        label = new JLabel("Select language");
        frame.add(label);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RadioButtonSwingDemo::new);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        label.setText(String.format("%s is selected", ae.getActionCommand()));
    }
}
