package sandbox.awt.image.filter.demo;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

public class LoadedImage extends Canvas {
    Image img;
    
    public LoadedImage(Image img){
        this.img = img;
    }
    
    void set(Image img){
        this.img = img;
        repaint();
    }
    
    @Override
    public void paint(Graphics g){
        if(img == null){
            g.drawString("there is no image", 10, 30);
        } else {
            g.drawImage(img, 0, 0, this);
        }
    }
    
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(img.getWidth(this), img.getHeight(this));
    }
    
    @Override
    public Dimension getMinimumSize(){
        return getPreferredSize();
    } 
}
