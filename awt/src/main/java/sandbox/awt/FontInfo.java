package sandbox.awt;

import java.awt.*;
import java.awt.event.*;

public class FontInfo extends Frame {

    public FontInfo() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        var f = g.getFont();
        var fontName = f.getName();
        var fontFamily = f.getFamily();
        int fontSize = f.getSize();
        int fontStyle = f.getStyle();

        var msg = "Font: " + fontName;

        msg += ", Family: " + fontFamily;
        msg += ", Size: " + fontSize + ", Style: ";

        if ((fontStyle & Font.BOLD) == Font.BOLD) {
            msg += "Bold ";
        }

        if ((fontStyle & Font.ITALIC) == Font.ITALIC) {
            msg += "Italic ";
        }

        if ((fontStyle & Font.PLAIN) == Font.PLAIN) {
            msg += "Plain";
        }

        g.drawString(msg, 10, 60);
    }

    public static void main(String[] args) {
        var appwin = new FontInfo();

        appwin.setSize(new Dimension(300, 100));
        appwin.setTitle("FontInfo");
        appwin.setVisible(true);
    }
}
