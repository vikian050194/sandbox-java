package sandbox.awt.image;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class HistogramPixelGrabber extends Frame {

    Dimension d;
    Image img;
    int iw;
    int ih;
    int[] pixels;
    int[] histogram = new int[256];
    int histogramMax = 0;
    Insets insets;

    public HistogramPixelGrabber() {

        var dialog = new FileDialog(this, "Select image", FileDialog.LOAD);
        dialog.setVisible(true);
        var imageFile = new File(dialog.getDirectory(), dialog.getFile());

        try {
            img = ImageIO.read(imageFile);
        } catch (IOException ex) {
            Logger.getLogger(SimpleImageLoad.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        iw = img.getWidth(null);
        ih = img.getHeight(null);
        pixels = new int[iw * ih];
        var pixelGrabber = new PixelGrabber(img, 0, 0, iw, ih, pixels, 0, iw);

        try {
            pixelGrabber.grabPixels();
        } catch (InterruptedException ex) {
            Logger.getLogger(HistogramPixelGrabber.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        for (int i = 0; i < iw * ih; i++) {
            int p = pixels[i];
            int r = 0xff & (p >> 16);
            int g = 0xff & (p >> 8);
            int b = 0xff & (p);
            int y = (int) (.33 * r + .56 * g + .11 * b);
            histogram[y]++;
        }

        for (int i = 0; i < 256; i++) {
            if (histogram[i] > histogramMax) {
                histogramMax = histogram[i];
            }
        }

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we
            ) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        insets = getInsets();

        g.drawImage(img, insets.left, insets.top, null);

        int x = (iw - 256) / 2;
        int lastY = ih - ih * histogram[0] / histogramMax;

        for (int i = 0; i < 256; i++) {
            int y = ih - ih * histogram[i] / histogramMax;
            g.setColor(new Color(i, i, i));
            g.fillRect(x + insets.left, y + insets.top, 1, ih - y);
            g.setColor(Color.red);
            g.drawLine((x - 1) + insets.left, lastY + insets.top, x + insets.left, y + insets.top);
            lastY = y;
        }
    }

    public static void main(String[] args) {
        var appwin = new HistogramPixelGrabber();

        appwin.setSize(new Dimension(1280, 1280));
        appwin.setTitle("HistogramPixelGrabber");
        appwin.setVisible(true);
    }
}
