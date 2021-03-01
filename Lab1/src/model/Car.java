package model;

import model.MotorizedVehicle;

import java.awt.*;

/**
 * The abstract base class for all cars.
 */
public abstract class Car extends MotorizedVehicle implements ITransportable {

    /**
     * @param color The color of the car.
     * @param enginePower The engine power of the car.
     * @param nrDoors The number of doors the car has.
     * @param name The name of the specific car.
     * @param point The starting position of the car. An x- and a y-coordinate.
     * @param dir The initial direction of the car.
     */
    public Car(Color color, double enginePower, int nrDoors, String name, Point point, Direction dir){
        super(color, enginePower, 0, nrDoors, name, point, dir);
    }
}
