import java.awt.*;

/**
 * A class for the cars of model Volvo240. Volvo240 is a subclass of Car, it inherits the methods and
 * variables of the abstract class Car. Volvo240 also implements the interface Movable, which describes the desired
 * methods for which the car should implement, to be able to move.
 * @author Valter Miari, Oskar Sturebrand, Clara Josefsson
 */

public class Volvo240 implements ICar {

    public final static double trimFactor = 1.25;
    private double xCord;
    private double yCord;
    private Direction dir;
    private Color color;
    private final String name = "Volvo240";
    private double speed = 0;
    private final double enginePower = 100;
    private final int nrDoors = 4;

    /**
     * The constructor that is called upon on creation of a Volvo240. It inherits the variables; nrDoors, enginePower,
     * speed, color and modelName; from its super class Car. With exception of color, all these variables and the
     * variable dir, have default values for a Volvo240, and are assigned a final default value upon
     * creation.
     * @param c The color of the car.
     * @param point The starting position of the car. An x- and a y-coordinate.
     */
    public Volvo240(Color c, Point point, Direction dir){
        this.color = c;
        this.xCord = point.getX();
        this.yCord = point.getY();
        this.dir = dir;
        stopEngine();
    }


    // From ICar
    @Override
    public int getNrDoors(){ return this.nrDoors; }

    @Override
    public double getEnginePower(){ return enginePower; }

    @Override
    public void startEngine(){ speed = 1; }

    @Override
    public void stopEngine(){ speed = 0; }


    // From IVehicle
    @Override
    public String getName(){ return this.name; }

    @Override
    public String getColor(){ return color.toString(); }

    @Override
    public void setDir(Direction d) { this.dir = d; }

    @Override
    public Direction getDir(){ return this.dir; }

    @Override
    public void move() {
        switch (dir) {
            case EAST -> this.xCord += getSpeed();
            case WEST -> this.xCord -= getSpeed();
            case NORTH -> this.yCord += getSpeed();
            case SOUTH -> this.yCord -= getSpeed();
        }
    }

    @Override
    public void turnRight() {
        switch (dir) {
            case EAST -> this.dir = Direction.SOUTH;
            case WEST -> this.dir = Direction.NORTH;
            case NORTH -> this.dir = Direction.EAST;
            case SOUTH -> this.dir = Direction.WEST;
        }
    }

    @Override
    public void turnLeft() {
        switch (dir) {
            case EAST -> this.dir = Direction.NORTH;
            case WEST -> this.dir = Direction.SOUTH;
            case NORTH -> this.dir = Direction.WEST;
            case SOUTH -> this.dir = Direction.EAST;
        }
    }

    @Override
    public void setXCord(double x) { this.xCord = x; }

    @Override
    public double getXCord() {
        return this.xCord;
    }

    @Override
    public void setYCord(double y) { this.yCord = y;}

    @Override
    public double getYCord() {
        return this.yCord;
    }

    @Override
    public void setSpeed(double speed){ speed = Math.min(speed, this.enginePower); }

    @Override
    public double getSpeed(){ return speed; }

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    @Override
    public void gas(double amount) {
        double gasFactor = Math.max(Math.min(amount, 1), 0);
        incrementSpeed(gasFactor);
    }

    @Override
    public void incrementSpeed(double amount){
        setSpeed(Math.min(getSpeed() + speedFactor() * amount, getEnginePower()));
    }

    @Override
    public void brake(double amount) {
            double brakeFactor = Math.max(Math.min(amount, 1), 0);
            decrementSpeed(brakeFactor);
    }

    @Override
    public void decrementSpeed(double amount){
        setSpeed(Math.max(getSpeed() - speedFactor() * amount,0));
    }

}
