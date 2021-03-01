package model;

import model.Transporter;

import java.awt.*;

/**
 * A car ferry in the form of the model model.SSBadger.
 */
public class SSBadger extends Transporter<Car> {

    /**
     * @param color The color of the model.SSBadger.
     * @param point The starting position of the model.SSBadger. An x- and a y-coordinate.
     * @param dir The initial direction of the model.SSBadger.
     * @param capacity The initial direction of the model.SSBadger.
     */
    public SSBadger(Color color, Point point, Direction dir, int capacity){
        super(color, 1000, 10, "model.SSBadger", point, dir, capacity);
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    /**
     * Adds load to the ferry, and makes sure it fits and is close enough to be loaded.
     * @param car The desired car to be added to the load of the ferry.
     */
    @Override
    public void addLoad(Car car){
        if (!isRampDown()){
            if (getYCord() - car.getXCord() > 1 | getLoadSize() - 1 >= getCapacity())
                System.out.println("Must move car closer");
            else {
                getLoad().add(car);
                car.setXCord(getXCord());
                car.setYCord(getYCord());
            }
        }
        else
            System.out.println("Ramp must be open!");
    }

    /**
     * Unloads the car using the first in, first out principle.
     * @return Returns the first car in the queue.
     */
    @Override
    public Car unload(){
        if (getLoadSize() > 0 && !isRampDown()) {
            Car car = getLoad().getFirst();
            car.setXCord(car.getXCord() + 1);
            car.setYCord(car.getYCord() + 1);
            return car;
        }
        System.out.println("The load is empty");
        return null;
    }

}
