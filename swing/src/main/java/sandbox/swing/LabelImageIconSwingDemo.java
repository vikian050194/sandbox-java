package sandbox.swing;

import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class LabelImageIconSwingDemo {

    public LabelImageIconSwingDemo() {
        String title = "A Label With ImageIcon Demo Application";

        JFrame frame = new JFrame(title);
        
        frame.setLayout(new FlowLayout());

        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

        var fc = new JFileChooser();
        fc.showOpenDialog(frame);
        var imageIcon = new ImageIcon(fc.getSelectedFile().getAbsolutePath());

        JLabel label = new JLabel(fc.getSelectedFile().getName(), imageIcon, JLabel.CENTER);

        frame.add(label);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LabelImageIconSwingDemo::new);
    }
}
