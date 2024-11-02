package sandbox.awt.image;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class SimpleImageLoad extends Frame {

    Image img;

    public SimpleImageLoad() {
        var dialog = new FileDialog(this, "Select image", FileDialog.LOAD);
        dialog.setVisible(true);
        var imageFile = new File(dialog.getDirectory(), dialog.getFile());
        try {
            img = ImageIO.read(imageFile);
        } catch (IOException ex) {
            Logger.getLogger(SimpleImageLoad.class.getName()).log(Level.SEVERE, null, ex);
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
        g.drawImage(img, getInsets().left, getInsets().top, null);
    }

    public static void main(String[] args) {
        var appwin = new SimpleImageLoad();

        appwin.setSize(new Dimension(1280, 720));
        appwin.setTitle("SimpleImageLoad");
        appwin.setVisible(true);
    }
}
