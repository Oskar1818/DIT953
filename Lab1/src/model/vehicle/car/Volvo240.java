package model.vehicle.car;

import model.vehicle.Direction;
import production.IProduction;
import java.awt.*;

/**
 * A class for the cars of model model.vehicle.car.Volvo240. model.vehicle.car.Volvo240 is a subclass of model.vehicle.car.Car, it inherits the methods and
 * variables of the abstract class model.vehicle.car.Car. model.vehicle.car.Volvo240 also implements the interface Movable, which describes the desired
 * methods for which the car should implement, to be able to move.
 * @author Valter Miari, Oskar Sturebrand, Clara Josefsson
 */

public class Volvo240 extends Car implements IProduction {

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
        super(color, 100.0, 4, "model.vehicle.car.Volvo240", point, dir);
        stopEngine();
    }

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }


}
