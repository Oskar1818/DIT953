package model.vehicle.car;

import model.interfaces.ITurbo;
import model.vehicle.Direction;
import model.vehicle.Vehicle;
import point.Point;
import java.awt.Color;



/**
 * A class for the cars of model model.vehicle.car.Saab95. model.vehicle.car.Saab95 is a subclass of model.vehicle.car.Car, it inherits the methods and
 * variables of the abstract class model.vehicle.car.Car. model.vehicle.car.Saab95 also implements the interface Movable, which describes the desired
 * methods for which the car should implement, to be able to move.
 * @author Valter Miari, Oskar Sturebrand, Clara Josefsson
 */
public class Saab95 extends Car implements ITurbo {

    private boolean turboOn;
    public final static double turboFactor = 1.3;

    /**
     * The constructor that is called upon on creation of a model.vehicle.car.Saab95. It inherits the variables; nrDoors, enginePower,
     * speed, color and modelName; from its super class model.vehicle.car.Car. With exception of color, all these variables and the
     * variables; turboOn and dir, have default values for a model.vehicle.car.Saab95, and are assigned a final default value upon
     * creation.
     * @param color The color of the car.
     * @param point The starting position of the car. An x- and a y-coordinate.
     * @param dir The starting direction of the car.
     */
    public Saab95(Color color, Point point, Direction dir){
	    super(color, 125.0, 2, "Saab95", point, dir);
        turboOn = false;
        stopEngine();
    }

    private Saab95(Color color, Point point, Direction dir, double speed) {
        super(color, 125, speed, 2, "Saab95", point, dir);
    }

    // Specific to saab95.
    /**
     * Checks if the turbo in the Saab is on.
     */
    @Override
    public boolean isTurboOn() { return this.turboOn; }

    /**
     * Turns on the turbo in the model.vehicle.car.Saab95. Hej
     */
    @Override
    public void setTurboOn(){
	    turboOn = true;
    }

    /**
     * Turns off the turbo in the model.vehicle.car.Saab95.
     */
    @Override
    public void setTurboOff(){
	    turboOn = false;
    }


    @Override
    public double getTurboPower() {return turboFactor; }


    @Override
    public double speedFactor() {
        if(turboOn)
            return 25; //getEnginePower() * 0.01 * turboFactor;
        else
            return getEnginePower() * 0.01;
    }

    @Override
    public Vehicle createVehicleWithNewCord(Point point) {
        return new Saab95(this.getColor(), point, this.getDirection());
    }

    @Override
    public Vehicle createVehicleWithNewDirection(Direction dir) {
        return new Saab95(this.getColor(), this.getPoint(), dir);
    }

    @Override
    public Vehicle createVehicleWithNewSpeed(double amount) {
        return new Saab95(this.getColor(), this.getPoint(), this.getDirection(), amount);
    }

    @Override
    public Vehicle createVehicleWithNewX(int xCord) {
        return new Saab95(this.getColor(), new Point(xCord, (int) this.getYCord()), this.getDirection());
    }

    @Override
    public Vehicle createVehicleWithNewY(int yCord) {
        return new Saab95(this.getColor(), new Point((int) this.getXCord(), yCord), this.getDirection());
    }
}