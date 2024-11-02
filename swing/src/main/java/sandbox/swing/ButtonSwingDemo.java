package sandbox.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class ButtonSwingDemo implements ActionListener {

    JLabel label;

    private String getIconPath(String name) {
        return String.format("/home/Icons/chrome/%s", name);
    }

    public ButtonSwingDemo() {
        String title = "Button Demo Application";

        JFrame frame = new JFrame(title);
        frame.setLayout(new FlowLayout());

        frame.setSize(500, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var icon1 = new ImageIcon(getIconPath("chrome-128.png"));
        var button1 = new JButton(icon1);
        button1.setActionCommand("b1");
        button1.addActionListener(this);
        frame.add(button1);

        var icon2 = new ImageIcon(getIconPath("chromium-128.png"));
        var button2 = new JButton(icon2);
        button2.setActionCommand("b2");
        button2.addActionListener(this);
        frame.add(button2);

        var icon3 = new ImageIcon(getIconPath("Google Chrome Canary.png"));
        var button3 = new JButton(icon3);
        button3.setActionCommand("b3");
        button3.addActionListener(this);
        frame.add(button3);

        var icon4 = new ImageIcon(getIconPath("Google Chrome Chromium.png"));
        var button4 = new JButton(icon4);
        button4.setActionCommand("b4");
        button4.addActionListener(this);
        frame.add(button4);

        label = new JLabel("Choose a Image");
        frame.add(label);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ButtonSwingDemo::new);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        label.setText(ae.getActionCommand());
    }
}
