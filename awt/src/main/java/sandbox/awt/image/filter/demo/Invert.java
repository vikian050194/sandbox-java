package sandbox.awt.image.filter.demo;

import java.awt.Frame;
import java.awt.Image;
import java.awt.image.FilteredImageSource;
import java.awt.image.RGBImageFilter;

public class Invert extends RGBImageFilter implements PlugInFilter {

    @Override
    public int filterRGB(int x, int y, int rgb) {
        int r = 0xff - (rgb >> 16) & 0xff;
        int g = 0xff - (rgb >> 8) & 0xff;
        int b = 0xff - rgb & 0xff;
        return (0xff000000 | r << 16 | g << 8 | b);
    }

    @Override
    public Image filter(Frame f, Image img) {
        return f.createImage(new FilteredImageSource(img.getSource(), this));
    }
}
