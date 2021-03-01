package view;

import model.vehicle.Vehicle;
import production.Production;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel implements IObserver {

    HashMap<String, Point> position;

    private BufferedImage bufferImages(Vehicle v) {
        try {
            return ImageIO.read(getClass().getResource("view/pics/" + v.getName() + ".jpg"));
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
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: How should this method be designed such that it isn't dependant on the model? A State pattern perhaps?
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
        g.drawImage(saabImage, saabPoint.x, saabPoint.y, null);
        g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null);
    }

    @Override
    public void update() {

    }
}
