package model.vehicle;

import point.Point;
import model.interfaces.IMove;
import model.interfaces.ITransportable;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The abstract base class for all vehicles.
 */
public abstract class Vehicle implements IMove, ITransportable {

    private double xCord;
    private double yCord;
    private final Point point;
    private Direction dir;
    private final Color color;
    private final String name;
    private final int nrDoors;

    /**
     *
     * @param color - The color of a vehicle.
     * @param nrDoors The number of doors of a vehicle.
     * @param name - The name of a specific instance of a vehicle.
     * @param point - The coordinates of a vehicle, represented as a point (x, y).
     * @param dir - The initial direction of the vehicle.
     */

    // constructor for model.vehicle.MotorizedVehicle
    public Vehicle(Color color, int nrDoors, String name, Point point, Direction dir) {
        this.color = new Color(color.getRGB());
        this.nrDoors = nrDoors;
        this.name = name;
        this.point = point;
        this.xCord = point.getX();
        this.yCord = point.getY();
        this.dir = dir;
    }

    public abstract Vehicle createVehicleWithNewCord(Point p);

    public abstract Vehicle createVehicleWithNewDirection(Direction dir);

    public abstract Vehicle createVehicleWithNewSpeed(double amount);

    public abstract Vehicle createVehicleWithNewX(double xCord);

    public abstract Vehicle createVehicleWithNewY(double yCord);

    //public abstract Vehicle

    /**
     * @return Returns the number of doors the vehicle has.
     */
    public int getNrDoors(){ return this.nrDoors; }

    /**
     * @return Returns the x- and the y-coordinate of the vehicle.
     */
    public Point getPoint() {return this.point; }

    /**
     * Makes the car go faster by increasing the speed via the incrementSpeed method.
     * @param amount amount the amount at which the speed should increase by.
     */
    public Vehicle gas(double amount) {
        double gasFactor = Math.max(Math.min(amount, 1), 0);
        return incrementSpeed(gasFactor);
    }
    //make gas abstract possibly

    /**
     * Makes the car go slower by decreasing the speed via the decrementSpeed method.
     * @param amount amount amount the amount at which the speed should decrease by.
     */
    public Vehicle brake(double amount) {
        double brakeFactor = Math.max(Math.min(amount, 1), 0); // 0 <= breakFactor <= 1
        return decrementSpeed(brakeFactor);
    }

    /**
     * @return Returns vehicle name.
     */
    public String getName(){ return this.name; }

    /**
     * @return Returns vehicle colour.
     */
    public String getColorName(){ return new Color(color.getRGB()).toString(); }

    public Color getColor() { return new Color(color.getRGB()); }

    /* interface functions */

    /**
     * @param d - Sets direction.
     */
    @Override
    public Vehicle setDirection(Direction d) { return createVehicleWithNewDirection(d); }

    /**
     * @return Returns direction of vehicle.
     */
    @Override
    public Direction getDirection() { return this.dir; }

    @Override
    public Direction getOppositeDirection(Direction dir) {
        ArrayList<Direction> directions = new ArrayList<>(Arrays.asList(Direction.values()));
        return switch (directions.indexOf(dir)) {
            case 0 -> directions.get(1);
            case 1 -> directions.get(0);
            case 2 -> directions.get(3);
            case 3 -> directions.get(2);
            default -> null;
        };
    }

    /**
     * Increases the speed of the model.vehicle.Vehicle by the input amount times the speed factor, and makes sure the
     * speed doesn't go above the engine power.
     * @param amount amount the amount at which the speed should decrease by.
     */
    @Override
    public abstract Vehicle incrementSpeed(double amount);

    /**
     * Decreases the speed of the Saab by the input amount times the speed factor, and makes sure the
     * speed doesn't go below 0.
     * @param amount amount the amount at which the speed should decrease by.
     */
    @Override
    public Vehicle decrementSpeed(double amount){
        return setSpeed(Math.max(getSpeed() - speedFactor() * amount,0));
    }

    /**
     * @param x - Sets the x-coordinate.
     */
    @Override
    public Vehicle setXCord(double x) { return createVehicleWithNewX(x); }

    /**
     * @return Returns the x-coordinate.
     */
    @Override
    public double getXCord() { return this.xCord; }

    /**
     * @param y - Sets the y-coordinate.
     */
    @Override
    public Vehicle setYCord(double y) { return createVehicleWithNewY(y); }

    /**
     * @return Returns y coordinate of vehicle.
     */
    @Override
    public double getYCord() { return this.yCord; }

    /**
     * @param speed - the desired speed.
     */
    @Override
    public abstract Vehicle setSpeed(double speed);
    //  this.speed = speed;

    /**
     * @return Gets the speed.
     */
    @Override
    public abstract double getSpeed();

    @Override
    public Vehicle move() {
        return switch (getDirection()) {
            case EAST -> setXCord(getXCord() + getSpeed());
            case WEST -> setXCord(getXCord() - getSpeed());
            case NORTH -> setYCord(getYCord() + getSpeed());
            case SOUTH -> setYCord(getYCord() - getSpeed());
        };
    }

    @Override
    public Vehicle turnRight() {
        return switch (getDirection()) {
            case EAST -> setDirection(Direction.SOUTH);
            case WEST -> setDirection(Direction.NORTH);
            case NORTH -> setDirection(Direction.EAST);
            case SOUTH -> setDirection(Direction.WEST);
        };
    }

    @Override
    public Vehicle turnLeft() {
        return switch (getDirection()) {
            case EAST -> setDirection(Direction.NORTH);
            case WEST -> setDirection(Direction.SOUTH);
            case NORTH -> setDirection(Direction.WEST);
            case SOUTH -> setDirection(Direction.EAST);
        };
    }

}
