package view;

import production.Tuple;

import java.awt.*;
import point.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.
public class DrawPanel extends JPanel{

    private ArrayList<Tuple<String, Point>> positions;

    private BufferedImage bufferImage(String name) {
        try {
            return ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + name + ".jpg"));
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
        this.positions = new ArrayList<>();
    }

    public void updateUI(ArrayList<Tuple<String, Point>> positions) {
        this.positions = new ArrayList<>(positions);
        repaint();
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        positions.forEach( t -> g.drawImage(bufferImage(t.getFst()), (int) t.getSnd().getX(), (int) t.getSnd().getY(), null));
    }
}
