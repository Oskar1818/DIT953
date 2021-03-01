package model;

import model.Vehicle;

import java.awt.*;

public abstract class MotorizedVehicle extends Vehicle {
    /**
     * @param color The color of the car.
     * @param enginePower The engine power of the car.
     * @param nrDoors The number of doors the car has.
     * @param name The name of the specific car.
     * @param point The starting position of the car. An x- and a y-coordinate.
     * @param dir The initial direction of the car.
     */
    private double enginePower;
    private double speed;

    public MotorizedVehicle(Color color,  double enginePower, double speed, int nrDoors, String name, Point point, Direction dir) {
        super(color, nrDoors, name, point, dir);
        this.speed = speed;
        this.enginePower = enginePower;
    }

    /**
     * @return Returns the engine power of the car.
     */
    public double getEnginePower(){ return this.enginePower; }

    /**
     * Starts the engine and sets the initial speed to 1.
     */
    public void startEngine(){ this.speed = 1; }

    /**
     * Stops the engine, which makes the car stop.
     */
    public void stopEngine(){ this.speed = 0; }

    @Override
    public double getSpeed() { return this.speed;}

    @Override
    public void incrementSpeed(double amount){
        this.speed = Math.min(speed + speedFactor() * amount, getEnginePower());
    }

    @Override
    public void setSpeed(double speed){ this.speed = (Math.min(speed, this.enginePower)); }

   /* @Override
    public void gas(double amount) {
        double gasFactor = Math.max(Math.min(amount, 1), 0);
        incrementSpeed(gasFactor);
    }*/
}
