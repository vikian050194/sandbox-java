package sandbox.awt;

import java.awt.*;
import java.awt.event.*;

class MyMouseAdapter extends MouseAdapter {

    SampleFonts sf;

    public MyMouseAdapter(SampleFonts sf) {
        this.sf = sf;
    }

    @Override
    public void mousePressed(MouseEvent me) {
        sf.next++;

        switch (sf.next) {
            case 0:
                sf.f = new Font("Dialog", Font.PLAIN, 12);
                sf.msg = "Dialog";
                break;
            case 1:
                sf.f = new Font("DialogInput", Font.PLAIN, 12);
                sf.msg = "DialogInput";
                break;
            case 2:
                sf.f = new Font("SansSerif", Font.PLAIN, 12);
                sf.msg = "SansSerif";
                break;
            case 3:
                sf.f = new Font("Serif", Font.PLAIN, 12);
                sf.msg = "Serif";
                break;
            case 4:
                sf.f = new Font("Monospaced", Font.PLAIN, 12);
                sf.msg = "Monospaced";
                break;
            default:
                throw new AssertionError();
        }

        if (sf.next == 4) {
            sf.next = -1;
        }
        sf.setFont(sf.f);
        sf.repaint();
    }
}

public class SampleFonts extends Frame {

    int next = 0;
    Font f;
    String msg;

    public SampleFonts() {
        f = new Font("Dialog", Font.PLAIN, 12);
        msg = "Dialog";
        setFont(f);

        addMouseListener(new MyMouseAdapter(this));
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, 10, 60);
    }

    public static void main(String[] args) {
        var appwin = new SampleFonts();

        appwin.setSize(new Dimension(200, 100));
        appwin.setTitle("SampleFonts");
        appwin.setVisible(true);
    }
}
