import java.awt.*;

/**
 * A class for the cars of model Saab95. Saab95 is a subclass of Car, it inherits the methods and
 * variables of the abstract class Car. Saab95 also implements the interface Movable, which describes the desired
 * methods for which the car should implement, to be able to move.
 * @author Valter Miari, Oskar Sturebrand, Clara Josefsson
 */
public class Saab95 implements ICar, Movable{

    private boolean turboOn;
    private double xCord;
    private double yCord;
    private Direction dir;
    private Color color;
    private final String name = "Saab95";
    private double currentSpeed = 0;
    private final double enginePower = 125;
    private final int nrDoors = 2;

    /**
     * The constructor that is called upon on creation of a Saab95. It inherits the variables; nrDoors, enginePower,
     * currentSpeed, color and modelName; from its super class Car. With exception of color, all these variables and the
     * variables; turboOn and dir, have default values for a Saab95, and are assigned a final default value upon
     * creation.
     * @param c The color of the car.
     * @param point The starting position of the car. An x- and a y-coordinate.
     */
    public Saab95(Color c, Point point, Direction dir){
	    turboOn = false;
	    this.xCord = point.getX();
	    this.yCord = point.getY();
	    this.dir = dir;
        stopEngine();
    }

    // From IVehicle
    @Override
    public String getName(){ return this.name; }

    @Override
    public String getColor(){ return color.toString(); }

    @Override
    public Direction getDir() { return this.dir; }

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
    public double getXCord() { return this.xCord; }

    @Override
    public double getYCord() { return this.yCord; }

    @Override
    public void setSpeed(double speed){ currentSpeed = Math.min(speed, this.enginePower); }

    @Override
    public double getSpeed(){ return currentSpeed; }

    @Override
    public double speedFactor() {
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
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
            double brakeFactor = Math.max(Math.min(amount, 1), 0); // 0 <= breakFactor <= 1
            decrementSpeed(brakeFactor);
    }

    @Override
    public void decrementSpeed(double amount){
        setSpeed(Math.max(getSpeed() - speedFactor() * amount,0));
    }


    // From ICar
    @Override
    public int getNrDoors(){ return this.nrDoors; }

    @Override
    public double getEnginePower(){ return enginePower; }

    @Override
    public void startEngine(){ currentSpeed = 1; }

    @Override
    public void stopEngine(){ currentSpeed = 0; }


    // Specific to saab95.
    /**
     * Checks if the turbo in the Saab is on.
     */
    public boolean isTurboOn() { return this.turboOn; }

    /**
     * Turns on the turbo in the Saab95.
     */
    public void setTurboOn(){
	    turboOn = true;
    }

    /**
     * Turns off the turbo in the Saab95.
     */
    public void setTurboOff(){
	    turboOn = false;
    }

}