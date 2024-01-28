package sandbox.awt.image.filter.demo;

import java.awt.Frame;
import java.awt.Image;
import java.awt.image.FilteredImageSource;
import java.awt.image.RGBImageFilter;

public class Contrast extends RGBImageFilter implements PlugInFilter {

    double gain = 1.2;

    private int multiclamp(int in, double factor) {
        in = (int) (in * factor);
        return in > 255 ? 255 : in;
    }

    private int cont(int in) {
        return (in < 128) ? (int) (in / gain) : multiclamp(in, gain);
    }

    @Override
    public int filterRGB(int x, int y, int rgb) {
        int r = cont((rgb >> 16) & 0xff);
        int g = cont((rgb >> 8) & 0xff);
        int b = cont(rgb & 0xff);
        return (0xff000000 | r << 16 | g << 8 | b);
    }

    @Override
    public Image filter(Frame f, Image img) {
        return f.createImage(new FilteredImageSource(img.getSource(), this));
    }
}
