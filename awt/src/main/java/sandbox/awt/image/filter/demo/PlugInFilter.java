package sandbox.awt.image.filter.demo;

import java.awt.Frame;
import java.awt.Image;

public interface PlugInFilter {
    Image filter(Frame f, Image img);
}
