package view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.
public class DrawPanel extends JPanel{

    private HashMap<String, Point> positions;

    private BufferedImage bufferImage(String name) {
        try {
            return ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + name + ".jpg"));
            // src/view/pics/Saab95.jpg
        }
        catch (IOException e) {
            e.printStackTrace(); // this or throw exception, or both?
            throw new RuntimeException("There is no such url");
        }
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.lightGray);
        this.positions = new HashMap<>();
    }

    public void updateUI(HashMap<String, Point> positions) {
        this.positions = new HashMap<>(positions);
        repaint();
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        positions.forEach( (name, pos) -> g.drawImage(bufferImage(name), pos.x, pos.y, null));
    }
}
