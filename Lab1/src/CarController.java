import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// TODO
// single responsibility använd morgans "och trick"
// Carfactory har referens till sina motsvarande bilar


//TODO CarController should only have references to VFactory. (Instance of).

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;

    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    //
    public Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern

    CarView view;
    // A list of cars, modify if needed
    Production vehicles;
    int gasAmount = 0;

    public CarController(CarView view, Production vehicles){
        this.view = view;
        this.vehicles = vehicles;
        addButtonFunctionality();
    }

    private void addButtonFunctionality(){
        view.gasSpinner.addChangeListener(e -> gasAmount = (int) ((JSpinner)e.getSource()).getValue());

        view.gasButton.addActionListener(e -> gas(gasAmount));

        view.turboOnButton.addActionListener(e -> turboOn());

        view.liftBedButton.addActionListener(e -> liftBed());

        view.brakeButton.addActionListener(e -> brake(gasAmount));

        view.turboOffButton.addActionListener(e -> turboOff());

        view.lowerBedButton.addActionListener(e -> lowerBed());

        view.startButton.addActionListener(e -> startAll());

        view.stopButton.addActionListener(e -> stopAll());
    }


    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            vehicles.getVehicleList().forEach( v -> {
                collisionDetection();
                v.move();
                int x = (int) Math.round(v.getXCord());
                int y = (int) Math.round(v.getYCord());
                view.drawPanel.moveit(v.getName(), x, y);
                // repaint() calls the paintComponent method of the panel
                view.drawPanel.repaint();
            });
            }
        }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        vehicles.getVehicleList().forEach( v -> v.gas(gas));

    }

    void brake(int amount) {
        double brake = ((double) amount / 100);
        vehicles.getVehicleList().forEach( v -> v.brake(brake));
    }

    void turboOn() {
        vehicles.getTurboList().forEach(ITurbo::setTurboOn);
    }

    void turboOff() { vehicles.getTurboList().forEach(ITurbo::setTurboOff); }

    void liftBed() { vehicles.getTransporterList().forEach( t -> t.setRampUp()); }

    // Does static methods in Production take away the pointers to the specific classes?
    void lowerBed() {
        vehicles.getTransporterList().forEach( t -> t.setRampDown());
    }

    public void startAll() {
        vehicles.getVehicleList().forEach(MotorizedVehicle::startEngine);
    }

    public void stopAll() {
        vehicles.getVehicleList().forEach(MotorizedVehicle::stopEngine);
    }

    public void collisionDetection(){
        vehicles.getVehicleList().forEach(v -> {
            if (v.getXCord() < 0 || v.getXCord() > 700 || v.getYCord() < 0 || v.getYCord() > 700 - 200) {
                v.setDirection(v.getOppositeDirection(v.getDirection()));
            }
        });
    }

}
