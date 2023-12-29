package sandbox.awt;

import java.awt.*;
import java.awt.event.*;

public class MultiLine extends Frame {

    int x = 20;
    int y = 40;

    public MultiLine() {
        var f = new Font("SansSarif", Font.PLAIN, 12);
        setFont(f);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        nextLine("This is on line one.", g);
        nextLine("This is o line two.", g);
        sameLine(" This is on same line.", g);
        sameLine(" This, too.", g);
        nextLine("This is on line three.", g);

        x = 20;
        y = 40;
    }

    void nextLine(String s, Graphics g) {
        var fm = g.getFontMetrics();
        y += fm.getHeight();
        x = 20;
        g.drawString(s, x, y);
        x += fm.stringWidth(s);
    }

    void sameLine(String s, Graphics g) {
        var fm = g.getFontMetrics();
        g.drawString(s, x, y);
        x += fm.stringWidth(s);
    }

    public static void main(String[] args) {
        var appwin = new MultiLine();

        appwin.setSize(new Dimension(500, 120));
        appwin.setTitle("MultiLine");
        appwin.setVisible(true);
    }
}
