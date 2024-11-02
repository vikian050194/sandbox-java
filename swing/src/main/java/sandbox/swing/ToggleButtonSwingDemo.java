package sandbox.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

public class ToggleButtonSwingDemo implements ActionListener {

    JLabel label;

    public ToggleButtonSwingDemo() {
        String title = "ToggleButton Demo Application";

        JFrame frame = new JFrame(title);
        frame.setLayout(new FlowLayout());

        frame.setSize(200, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var button1 = new JToggleButton("On/Off");
        button1.addActionListener((ie) -> {
            if (button1.isSelected()) {
                label.setText("Button is on");
            } else {
                label.setText("Button is off");
            }
        });
        frame.add(button1);

        label = new JLabel("Button is off");
        frame.add(label);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToggleButtonSwingDemo::new);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        label.setText(ae.getActionCommand());
    }
}
