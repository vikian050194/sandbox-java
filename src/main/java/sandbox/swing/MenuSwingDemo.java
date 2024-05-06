package sandbox.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class MenuSwingDemo implements ActionListener {

    class DebugAction extends AbstractAction {

        public DebugAction(String name, String text, int mnem, int accel, String tTip) {
            super(name);
            putValue(NAME, text);
            putValue(ACCELERATOR_KEY, KeyStroke.getAWTKeyStroke(accel, InputEvent.CTRL_DOWN_MASK));
            putValue(MNEMONIC_KEY, mnem);
            putValue(SHORT_DESCRIPTION, tTip);
        }

        public void actionPerformed(ActionEvent ae) {
            String command = ae.getActionCommand();

            label.setText(String.format("%s is selected", command));

            if (command.equals("↓")) {
                clearAct.setEnabled(true);
                setAct.setEnabled(false);
            } else if (command.equals("↑")) {
                clearAct.setEnabled(false);
                setAct.setEnabled(true);
            }
        }
    }

    JLabel label;
    JMenuBar bar;
    JToolBar toolbar;
    JPopupMenu popupMenu;

    DebugAction setAct;
    DebugAction clearAct;
    DebugAction resumeAct;

    public MenuSwingDemo() {
        String title = "Menu Demo Application";

        JFrame frame = new JFrame(title);

        frame.setLayout(new BorderLayout());
        frame.setSize(360, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel();

        bar = new JMenuBar();

        makeFileMenu();

        makeActions();

        makeToolBar();

        makeOptionsMenu();

        makeHelpMenu();

        makeEditPUMenu();

        frame.add(label, BorderLayout.CENTER);

        frame.add(toolbar, BorderLayout.NORTH);

        frame.setJMenuBar(bar);

        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (me.isPopupTrigger()) {
                    popupMenu.show(me.getComponent(), me.getX(), me.getY());
                }
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                if (me.isPopupTrigger()) {
                    popupMenu.show(me.getComponent(), me.getX(), me.getY());
                }
            }
        });

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

    void makeFileMenu() {
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
    }

    void makeOptionsMenu() {
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

        var debug = new JMenu("Debug");
        debug.add(new JMenuItem(setAct)).addActionListener(this);
        debug.add(new JMenuItem(clearAct)).addActionListener(this);
        debug.add(new JMenuItem(resumeAct)).addActionListener(this);
        options.add(debug);

        options.addSeparator();
        options.add(new JMenuItem("Reset")).addActionListener(this);

        bar.add(options);
    }

    void makeHelpMenu() {
        var help = new JMenu("Help");

        var about = help.add(new JMenuItem("About"));
        about.addActionListener(this);
        about.setToolTipText("Info about the Menu Demo Application program");

        bar.add(help);
    }

    void makeActions() {
        setAct = new DebugAction("Set Breakpoint", "↓", KeyEvent.VK_S, KeyEvent.VK_B, "Set a break point");
        clearAct = new DebugAction("Clear Breakpoint", "↑", KeyEvent.VK_C, KeyEvent.VK_L, "Clear a break point");
        resumeAct = new DebugAction("Resume", "↬", KeyEvent.VK_R, KeyEvent.VK_R, "Resume execution after breakpoint");
    }

    void makeToolBar() {
        toolbar = new JToolBar("Debug");

        var setBreakpoint = new JButton(setAct);
        var clearBreakpoint = new JButton(clearAct);
        var resumeBreakpoint = new JButton(resumeAct);

        toolbar.add(setBreakpoint);
        toolbar.add(clearBreakpoint);
        toolbar.add(resumeBreakpoint);

        setBreakpoint.addActionListener(this);
        clearBreakpoint.addActionListener(this);
        resumeBreakpoint.addActionListener(this);
    }

    void makeEditPUMenu() {
        popupMenu = new JPopupMenu();

        popupMenu.add(new JMenuItem("Cut")).addActionListener(this);
        popupMenu.add(new JMenuItem("Copy")).addActionListener(this);
        popupMenu.add(new JMenuItem("Paste")).addActionListener(this);
    }
}
