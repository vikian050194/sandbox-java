package sandbox.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

class PaintPanel extends JPanel {

    Insets insets;

    Random rnd;

    PaintPanel() {
        setBorder(BorderFactory.createLineBorder(Color.RED, 5));

        rnd = new Random();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x1, y1, x2, y2;

        insets = getInsets();

        int height = getHeight();
        int width = getWidth();

        for (int i = 0; i < 10; i++) {
            x1 = rnd.nextInt(width - insets.left);
            y1 = rnd.nextInt(height - insets.bottom);
            x2 = rnd.nextInt(width - insets.left);
            y2 = rnd.nextInt(height - insets.bottom);

            g.drawLine(x1, y1, x2, y2);
        }
    }
}

public class PaintSwingDemo {

    PaintPanel panel;

    public PaintSwingDemo() {
        String title = "Paint Demo";

        JFrame frame = new JFrame(title);

        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new PaintPanel();

        frame.add(panel);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PaintSwingDemo::new);
    }
}
