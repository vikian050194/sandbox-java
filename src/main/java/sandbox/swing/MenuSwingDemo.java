package sandbox.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class MenuSwingDemo implements ActionListener {

    JLabel label;

    public MenuSwingDemo() {
        String title = "Menu Demo Application";

        JFrame frame = new JFrame(title);

        frame.setLayout(new FlowLayout());
        frame.setSize(220, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel();
        frame.add(label);

        var bar = new JMenuBar();

        var file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);
        var open = file.add(new JMenuItem("Open", KeyEvent.VK_O));
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        open.addActionListener(this);
        var close = file.add(new JMenuItem("Close", KeyEvent.VK_C));
        close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
        close.addActionListener(this);
        var save = file.add(new JMenuItem("Save", KeyEvent.VK_S));
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        save.addActionListener(this);
        var exit = file.add(new JMenuItem("Exit", KeyEvent.VK_E));
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
        exit.addActionListener(this);
        bar.add(file);

        var options = new JMenu("Options");
        var colors = new JMenu("Colors");
        colors.add(new JCheckBoxMenuItem("Red")).addActionListener(this);
        colors.add(new JCheckBoxMenuItem("Green")).addActionListener(this);
        colors.add(new JCheckBoxMenuItem("Blue")).addActionListener(this);
        options.add(colors);
        var priority = new JMenu("Priority");
        var highPriority = priority.add(new JRadioButtonMenuItem("High"));
        highPriority.addActionListener(this);
        var lowPriority = priority.add(new JRadioButtonMenuItem("Low"));
        lowPriority.addActionListener(this);
        var bg = new ButtonGroup();
        bg.add(highPriority);
        bg.add(lowPriority);
        options.add(priority);

        options.addSeparator();
        options.add(new JMenuItem("Reset")).addActionListener(this);
        bar.add(options);

        var help = new JMenu("Help");
        var about = help.add(new JMenuItem("About"));
        about.addActionListener(this);
        about.setToolTipText("Info about the Menu Demo Application program");
        bar.add(help);

        frame.setJMenuBar(bar);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuSwingDemo::new);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        var command = ae.getActionCommand();

        if (command.equals("Exit")) {
            System.exit(0);
        }

        label.setText(ae.getActionCommand());
    }
}
