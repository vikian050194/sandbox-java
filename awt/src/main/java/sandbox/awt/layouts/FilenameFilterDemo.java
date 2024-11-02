package sandbox.awt.layouts;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class FilenameFilterDemo extends Frame {

    String command = "<null>";

    CheckboxMenuItem debug;
    CheckboxMenuItem test;

    public FilenameFilterDemo() {
        var bar = new MenuBar();
        setMenuBar(bar);

        var file = new Menu("File");
        MenuItem i1 = file.add(new MenuItem("New..."));
        var openShortcut = new MenuShortcut(KeyEvent.VK_O, false);
        MenuItem i2 = file.add(new MenuItem("Open...", openShortcut));
        MenuItem i3 = file.add(new MenuItem("Close"));
        MenuItem i4 = file.add(new MenuItem("-"));
        var quitShortcut = new MenuShortcut(KeyEvent.getExtendedKeyCodeForChar('Q'), true);
        MenuItem i5 = file.add(new MenuItem("Quit...", quitShortcut));
        bar.add(file);

        var edit = new Menu("Edit");
        MenuItem i6 = edit.add(new MenuItem("Cut"));
        MenuItem i7 = edit.add(new MenuItem("Copy"));
        MenuItem i8 = edit.add(new MenuItem("Paste"));
        MenuItem i9 = edit.add(new MenuItem("-"));

        var sub = new Menu("Special");
        var i10 = sub.add(new MenuItem("First"));
        var i11 = sub.add(new MenuItem("Second"));
        var i12 = sub.add(new MenuItem("Third"));
        edit.add(sub);

        debug = new CheckboxMenuItem("Debug");
        edit.add(debug);
        test = new CheckboxMenuItem("Test");
        edit.add(test);

        bar.add(edit);

        var handler = new MenuHandler();

        i1.addActionListener(handler);
//        i2.addActionListener(handler);
        i3.addActionListener(handler);
        i4.addActionListener(handler);
        i5.addActionListener(handler);
        i6.addActionListener(handler);
        i7.addActionListener(handler);
        i8.addActionListener(handler);
        i9.addActionListener(handler);
        i10.addActionListener(handler);
        i11.addActionListener(handler);
        i12.addActionListener(handler);

        debug.addItemListener(handler);
        test.addItemListener(handler);

        i5.addActionListener((ae) -> System.exit(0));

        i2.addActionListener((ae) -> {
            var dialog = new FileDialog(this, "Select directory", FileDialog.LOAD);
            dialog.setFilenameFilter(new TxtFilter());
            dialog.setVisible(true);
            command = dialog.getFile();
            repaint();
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(String.format("Command: %s", command), 10, 220);
        g.drawString(String.format("Debug: %s", debug.getState()), 10, 240);
        g.drawString(String.format("Test: %s", test.getState()), 10, 260);
    }

    public static void main(String[] args) {
        var appwin = new FilenameFilterDemo();

        appwin.setSize(new Dimension(300, 300));
        appwin.setTitle("FilenameFilterDemo");
        appwin.setVisible(true);
    }

    class MenuHandler implements ActionListener, ItemListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            command = ae.getActionCommand();

            repaint();
        }

        @Override
        public void itemStateChanged(ItemEvent ie) {
            repaint();
        }
    }

    class TxtFilter implements FilenameFilter {

        @Override
        public boolean accept(File dir, String name) {
            var pattern = Pattern.compile(".*\\.txt", Pattern.CASE_INSENSITIVE);
            var isMatch = pattern.matcher(name).matches();
            return isMatch;
        }
    }
}
