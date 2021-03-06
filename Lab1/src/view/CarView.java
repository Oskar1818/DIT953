package view;

import production.Tuple;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class CarView extends JFrame implements IPositionObserver {
    private static final int X = 800;
    private static final int Y = 800;

    JPanel controlPanel = new JPanel();
    public DrawPanel drawPanel = new DrawPanel(X, Y-240);

    JPanel gasPanel = new JPanel();
    public JSpinner gasSpinner = new JSpinner();
    JLabel gasLabel = new JLabel("Amount of gas");

    public JButton gasButton = new JButton("Gas");
    public JButton brakeButton = new JButton("Brake");
    public JButton turboOnButton = new JButton("<html><center>Saab<br><center>Turbo<br>on</center></html>\n"); //"<html><center>READER<br>STOP</center></html>\n"
    public JButton turboOffButton = new JButton("<html><center>Saab<br><center>Turbo<br>off</center></html>\n");
    public JButton liftBedButton = new JButton("<html><center>Scania<br><center>Lift<br>Bed</center></html>\n");
    public JButton lowerBedButton = new JButton("<html><center>Scania<br><center>Lower<br>Bed</center></html>\n");

    public JButton startButton = new JButton("<html><center>Start<br><center>All<br>Cars</center></html>\n");
    public JButton stopButton = new JButton("<html><center>Stop<br><center>All<br>Cars</center></html>\n");

    public JButton addButton = new JButton("<html><center>Add<br><center>Random<br>Car</center></html>\n");
    public JButton removeButton = new JButton("<html><center>Remove<br><center>a<br>Car</center></html>\n");

    // Constructor
    public CarView(String framename){
        initComponents(framename);
    }

    // Sets everything in place and fits everything
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X+20,Y+5));
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 2));
        this.add(drawPanel);

        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        1000, //max
                        10);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.setPreferredSize(new Dimension(100,50));


        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(addButton, 3);
        controlPanel.add(brakeButton, 4);
        controlPanel.add(turboOffButton, 5);
        controlPanel.add(lowerBedButton, 6);
        controlPanel.add(removeButton, 7);
        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        this.add(controlPanel);
        //controlPanel.setBackground(Color.WHITE);


        //startButton.setBackground(Color.BLUE);
        startButton.setForeground(Color.BLACK);
        startButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(startButton);


        //stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.BLACK);
        stopButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(stopButton);


        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        // Make the frame visible
        this.setVisible(true);

        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void update(ArrayList<Tuple<String, Point>> positions) {
        drawPanel.updateUI(positions);
    }
}