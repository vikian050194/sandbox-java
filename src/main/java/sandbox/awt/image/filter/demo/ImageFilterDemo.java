package sandbox.awt.image.filter.demo;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class ImageFilterDemo extends Frame implements ActionListener {

    Image img;
    PlugInFilter pif;
    Image fimg;
    LoadedImage lim;
    Label lab;
    Button reset;

    String[] filters = {"Grayscale", "Invert", "Contrast", "Blur", "Sharpen"};
    HashMap<String, PlugInFilter> filtersImpl;

    public ImageFilterDemo() {
        // Class.forName(a).getConstructor().newInstance() is not working
        filtersImpl = new HashMap<>();
        filtersImpl.put("Grayscale", new Grayscale());
        filtersImpl.put("Invert", new Invert());
        filtersImpl.put("Contrast", new Contrast());
        filtersImpl.put("Blur", new Blur());
        filtersImpl.put("Sharpen", new Sharpen());

        var dialog = new FileDialog(this, "Select image", FileDialog.LOAD);
        dialog.setVisible(true);
        var imageFile = new File(dialog.getDirectory(), dialog.getFile());
        try {
            img = ImageIO.read(imageFile);
        } catch (IOException ex) {
            Logger.getLogger(ImageFilterDemo.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        var p = new Panel();
        add(p, BorderLayout.SOUTH);

        reset = new Button("Reset");
        reset.addActionListener(this);
        p.add(reset);

        for (String filter : filters) {
            var b = new Button(filter);
            b.addActionListener(this);
            p.add(b);
        }

        lab = new Label("");
        add(lab, BorderLayout.NORTH);

        lim = new LoadedImage(img);
        add(lim, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        var appwin = new ImageFilterDemo();

        appwin.setSize(new Dimension(1280, 720));
        appwin.setTitle(appwin.getClass().getSimpleName());
        appwin.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        var a = ae.getActionCommand();

        if ("Reset".equals(a)) {
            lim.set(img);
        } else {
//            try {
            //pif = (PlugInFilter) (Class.forName(a).getConstructor().newInstance());
            pif = filtersImpl.get(a);
            fimg = pif.filter(this, img);
            lim.set(fimg);
            repaint();
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(ImageFilterDemo.class.getName()).log(Level.SEVERE, null, ex);
//                lab.setText(a + " is not found");
//                lim.set(img);
//                repaint();
//            } catch (InstantiationException ex) {
//                lab.setText("cound not create new " + a);
//            } catch (IllegalAccessException ex) {
//                lab.setText("there is no access to " + a);
//            } catch (NoSuchMethodException | InvocationTargetException ex) {
//                lab.setText("filter creation error " + ex);
//            }
        }
    }
}
