package sandbox.awt.image;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.MemoryImageSource;

public class MemoryImageGenerator extends Frame {

    Image img;
    int w = 512;
    int h = 512;

    public MemoryImageGenerator() {
        var pixels = new int[w * h];
        int i = 0;

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int r = (x ^ y) & 0xff;
                int g = (x * 2 ^ y * 2) & 0xff;
                int b = (x * 4 ^ y * 4) & 0xff;
                pixels[i++] = (255 << 24) | (r << 16) | (g << 8) | b;
            }
        }

        img = createImage(new MemoryImageSource(w, h, pixels, 0, w));

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(img, getInsets().left, getInsets().top, null);
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    public static void main(String[] args) {
        var appwin = new MemoryImageGenerator();

        appwin.setSize(new Dimension(400, 400));
        appwin.setTitle("MemoryImageGenerator");
        appwin.setVisible(true);
    }
}
