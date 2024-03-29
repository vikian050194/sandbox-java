package sandbox.awt.image.filter.demo;

import java.awt.Frame;
import java.awt.Image;
import java.awt.image.FilteredImageSource;
import java.awt.image.RGBImageFilter;

public class Grayscale extends RGBImageFilter implements PlugInFilter {

    @Override
    public int filterRGB(int x, int y, int rgb) {
        int r = (rgb >> 16) & 0xff;
        int g = (rgb >> 8) & 0xff;
        int b = rgb & 0xff;
        int k = (int) (.56 * g + .33 * r + .11 * b);
        return (0xff000000 | k << 16 | k << 8 | k);
    }

    @Override
    public Image filter(Frame f, Image img) {
        return f.createImage(new FilteredImageSource(img.getSource(), this));
    }
}
