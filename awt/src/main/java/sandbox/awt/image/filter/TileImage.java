package sandbox.awt.image.filter;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class TileImage extends Frame {

    Image img;
    Image[] cells = new Image[4 * 4];
    int iw;
    int ih;
    int th;
    int tw;

    public TileImage() {
        var dialog = new FileDialog(this, "Select image", FileDialog.LOAD);
        dialog.setVisible(true);
        var imageFile = new File(dialog.getDirectory(), dialog.getFile());
        try {
            img = ImageIO.read(imageFile);
        } catch (IOException ex) {
            Logger.getLogger(TileImage.class.getName()).log(Level.SEVERE, null, ex);
        }

        iw = img.getWidth(null);
        ih = img.getHeight(null);
        tw = iw / 4;
        th = ih / 4;

        CropImageFilter f;
        FilteredImageSource fis;

        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                f = new CropImageFilter(tw * x, th * y, tw, th);
                fis = new FilteredImageSource(img.getSource(), f);
                int i = y * 4 + x;
                cells[i] = createImage(fis);
            }
        }

        for (int i = 0; i < 32; i++) {
            int si = (int) (Math.random() * 16);
            int di = (int) (Math.random() * 16);
            var tmp = cells[si];
            cells[si] = cells[di];
            cells[di] = tmp;
        }

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                g.drawImage(cells[y * 4 + x], x * tw + getInsets().left, y * th + getInsets().top, null);
            }
        }
    }

    public static void main(String[] args) {
        var appwin = new TileImage();

        appwin.setSize(new Dimension(1280, 720));
        appwin.setTitle(appwin.getClass().getSimpleName());
        appwin.setVisible(true);
    }
}
