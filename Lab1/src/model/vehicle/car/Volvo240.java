package model.vehicle.car;

import model.vehicle.Direction;
import model.vehicle.Vehicle;
import java.awt.Color;
import point.Point;

/**
 * A class for the cars of model model.vehicle.car.Volvo240. model.vehicle.car.Volvo240 is a subclass of model.vehicle.car.Car, it inherits the methods and
 * variables of the abstract class model.vehicle.car.Car. model.vehicle.car.Volvo240 also implements the interface Movable, which describes the desired
 * methods for which the car should implement, to be able to move.
 * @author Valter Miari, Oskar Sturebrand, Clara Josefsson
 */

public final class Volvo240 extends Car {

    public final static double trimFactor = 1.25;

    /**
     * The constructor that is called upon on creation of a model.vehicle.car.Volvo240. It inherits the variables; nrDoors, enginePower,
     * speed, color and modelName; from its super class model.vehicle.car.Car. With exception of color, all these variables and the
     * variable dir, have default values for a model.vehicle.car.Volvo240, and are assigned a final default value upon
     * creation.
     * @param color The color of the car.
     * @param point The starting position of the car. An x- and a y-coordinate.
     */
    public Volvo240(Color color, Point point, Direction dir){
        super(color, 100.0, 4, "Volvo240", point, dir);
        stopEngine();
    }

    private Volvo240(Color color, Point point, Direction dir, double speed) {
        super(color, 125, speed, 2, "Saab95", point, dir);
    }

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }


    @Override
    public Vehicle createVehicleWithNewCord(Point point) {
        return new Volvo240(this.getColor(), point, this.getDirection());
    }

    @Override
    public Vehicle createVehicleWithNewDirection(Direction dir) {
        return new Volvo240(this.getColor(), this.getPoint(), dir);
    }

    @Override
    public Vehicle createVehicleWithNewSpeed(double amount) {
        return new Volvo240(this.getColor(), this.getPoint(), this.getDirection(), amount);
    }

    @Override
    public Vehicle createVehicleWithNewX(int xCord) {
        return new Volvo240(this.getColor(), new Point(xCord, (int) this.getYCord()), this.getDirection());
    }

    @Override
    public Vehicle createVehicleWithNewY(int yCord) {
        return new Volvo240(this.getColor(), new Point((int) this.getXCord(), yCord), this.getDirection());
    }
}
