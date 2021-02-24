import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// TODO
// knapparna kan inte ligga i carView
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
    ArrayList<MotorizedVehicle> vehicles;
    int gasAmount = 0;

    public CarController(CarView view, ArrayList<MotorizedVehicle> vehicles){
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


    //methods:

    /*public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.vehicles.add(new Volvo240(Color.red, new Point(0,0), Direction.EAST));
        cc.vehicles.add(new Saab95(Color.BLACK, new Point(0,200), Direction.EAST));
        cc.vehicles.add(new Scania(Color.BLACK, new Point(0,400), Direction.EAST, 10));

        // Start a new view and send a reference of self

        // Start the timer
        cc.timer.start();

    }*/

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (MotorizedVehicle car : vehicles) {
                car.move();
                int x = (int) Math.round(car.getXCord());
                int y = (int) Math.round(car.getYCord());
                view.drawPanel.moveit(car.getName(), x, y);
                // repaint() calls the paintComponent method of the panel
                view.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (MotorizedVehicle car : vehicles
                ) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount / 100);
        for (MotorizedVehicle car : vehicles)
            car.brake(brake);
    }

    void turboOn() {
        for (MotorizedVehicle car : vehicles) {
            if (car instanceof Saab95)
                ((Saab95) car).setTurboOn();
        }
    }

    void turboOff() {
        for (MotorizedVehicle car : vehicles) {
            if (car instanceof Saab95)
                ((Saab95) car).setTurboOff();
        }
    }

    void liftBed() {
        for(MotorizedVehicle truck : vehicles) {
            if (truck instanceof Transporter)
                ((Scania) truck).setRampUp();
        }
    }

    void lowerBed() {
        for(MotorizedVehicle truck : vehicles) {
            if (truck instanceof Transporter)
                ((Scania) truck).setRampDown();
    }
}

    public void startAll() {
        for (MotorizedVehicle car : vehicles) {
            car.startEngine();
        }
    }

    public void stopAll() {
        for (MotorizedVehicle car : vehicles) {
            car.stopEngine();
        }
    }

}
