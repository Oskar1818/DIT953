package view;

import model.Vehicle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel implements IObserver {

    // Just a single image, TODO: Generalize
    //TODO make some sort of interface for the pictures
    //private ArrayList<BufferedImage> carPics = new ArrayList<>();
    private BufferedImage volvoImage;
    private BufferedImage saabImage;
    private BufferedImage scaniaImage;


    // To keep track of a singel cars position
    Point volvoPoint = new Point(0, 0);
    Point saabPoint = new Point(0, -200);
    Point scaniaPoint = new Point(0, -400);

    // TODO: Make this genereal for all cars
    public void moveit(String name, int x, int y){
        if (name.equals("model.Volvo240")) {
            volvoPoint.x = x;
            volvoPoint.y = y;
        }
        else if (name.equals("model.Saab95")) {
            saabPoint.x = x;
            saabPoint.y = y;
        }
        else if (name.equals("model.Scania")) {
            scaniaPoint.x = x;
            scaniaPoint.y = y;
        }
    }

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
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "view.pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("model.Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: view.pics -> MOVE *.jpg to view.pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            // Lab1/src/view.pics

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }



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
