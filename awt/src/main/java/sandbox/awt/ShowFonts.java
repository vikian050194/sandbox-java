package sandbox.awt;

import java.awt.*;
import java.awt.event.*;

public class ShowFonts extends Frame {

    String msg = "First five fonts: ";
    GraphicsEnvironment ge;

    public ShowFonts() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

        var fontList = ge.getAvailableFontFamilyNames();
        for (int i = 0; i < 5; i++) {
            msg += fontList[i] + " ";
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, 20, 60);
    }

    public static void main(String[] args) {
        var appwin = new ShowFonts();

        appwin.setSize(new Dimension(500, 100));
        appwin.setTitle("ShowFonts");
        appwin.setVisible(true);
    }
}
