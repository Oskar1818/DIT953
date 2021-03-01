package view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    HashMap<String, Point> position;

    private BufferedImage bufferImage(String name) {
        try {
            return ImageIO.read(getClass().getResource("pics/" + name + ".jpg"));
        }
        catch (IOException e) {
            e.printStackTrace(); // this or throw exception, or both?
            throw new RuntimeException("There is no such url");
        }
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, HashMap<String, Point> position) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.lightGray);
        this.position = position;
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        position.forEach( (name, pos) -> g.drawImage(bufferImage(name), pos.x, pos.y, null));
    }
}
