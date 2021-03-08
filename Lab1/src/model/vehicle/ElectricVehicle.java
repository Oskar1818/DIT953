package model.vehicle;

import java.awt.Color;
import point.Point;

public abstract class ElectricVehicle extends Vehicle {

    /**
     *  @param color The color of the car.
     *  @param nrDoors The number of doors the car has.
     *  @param name The name of the specific car.
     *  @param point The starting position of the car. An x- and a y-coordinate.
     *  @param dir The initial direction of the car.
     * @param batteryCapacity The battery capacity of the vehicle.
     * @param range Maximum range the vehicle can move before it needs charging
     */

    private double batteryCapacity;
    private double range;

    public ElectricVehicle(Color color, int nrDoors, String name, Point point,
                           Direction dir, double batteryCapacity, double range){

        super(color, nrDoors, name, point, dir);
        this.batteryCapacity = batteryCapacity;
        this.range = range;
    }

    /**
     * @return Returns the battery capacity of the vehicle
     */
    public double getBatteryCapacity(){ return batteryCapacity; }

    /**
     * @return Returns the maximum range the vehicle can move before it needs charging
     */
    public double getRange(){ return range; }

    public void setBatteryCapacity(double c){ this.batteryCapacity = c; }

    public void setRange(double r){ this.range = r; }
}