import java.awt.*;

/**
 * A class for the cars of model Saab95. Saab95 is a subclass of Car, it inherits the methods and
 * variables of the abstract class Car. Saab95 also implements the interface Movable, which describes the desired
 * methods for which the car should implement, to be able to move.
 * @author Valter Miari, Oskar Sturebrand, Clara Josefsson
 */
public class Saab95 extends Car implements Movable{

    public boolean turboOn;
    private double xCord;
    private double yCord;
    private Direction dir;

    /**
     * The constructor that is called upon on creation of a Saab95. It inherits the variables; nrDoors, enginePower,
     * currentSpeed, color and modelName; from its super class Car. With exception of color, all these variables and the
     * variables; turboOn and dir, have default values for a Saab95, and are assigned a final default value upon
     * creation.
     * @param c The color of the car.
     * @param point The starting position of the car. An x- and a y-coordinate.
     */
    public Saab95(Color c, Point point){
        super(2, 125, 10, c, "Saab95");
	    turboOn = false;
	    this.xCord = point.getX();
	    this.yCord = point.getY();
	    dir = Direction.EAST;
        stopEngine();
    }

    /**
     *
     * @return returns the x-coordinate of the Saab.
     */
    public double getXCord() { return this.xCord; }

    /**
     *
     * @return returns the y-coordinate of the Saab.
     */
    public double getYCord() {
        return this.yCord;
    }

    /**
     * A method that moves the Saab, with its current speed, in the direction that it's pointing at.
     */
    @Override
    public void move() {
        switch (dir) {
            case EAST -> this.xCord += getCurrentSpeed();
            case WEST -> this.xCord -= getCurrentSpeed();
            case NORTH -> this.yCord += getCurrentSpeed();
            case SOUTH -> this.yCord -= getCurrentSpeed();
        }
    }

    /**
     * Turns the car left, by changing the latitude or the longitude, depending on where the car is pointing.
     */
    @Override
    public void turnLeft() {
        switch (dir) {
            case EAST -> this.dir = Direction.NORTH;
            case WEST -> this.dir = Direction.SOUTH;
            case NORTH -> this.dir = Direction.EAST;
            case SOUTH -> this.dir = Direction.WEST;
        }
    }

    /**
     * Turns the car right, by changing the latitude or the longitude, depending on where the car is pointing.
     */
    @Override
    public void turnRight() {
        switch (dir) {
            case EAST -> this.dir = Direction.SOUTH;
            case WEST -> this.dir = Direction.NORTH;
            case NORTH -> this.dir = Direction.EAST;
            case SOUTH -> this.dir = Direction.WEST;
        }
    }

    /**
     * Increases the speed of the Saab by the input amount times the speed factor, and makes sure the
     * speed doesn't exceed the engine power of the car.
     * @param amount the amount at which the speed should increase by.
     */
    @Override
    public void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    /**
     * Increases the speed of the Saab by the input amount times the speed factor, and makes sure the
     * speed doesn't go below 0.
     * @param amount amount the amount at which the speed should decrease by.
     */
    @Override
    public void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }

    /**
     * Makes the car go faster by increasing the speed via the incrementSpeed method.
     * @param amount amount the amount at which the speed should increase by.
     */
    @Override
    public void gas(double amount) {
            double gasFactor = Math.max(Math.min(amount, 1), 0);
            incrementSpeed(gasFactor);
    }

    /**
     * Makes the car go slower by decreasing the speed via the decrementSpeed method.
     * @param amount amount amount the amount at which the speed should decrease by.
     */
    @Override
    public void brake(double amount) {
            double brakeFactor = Math.max(Math.min(amount, 1), 0); // 0 <= breakFactor <= 1
            decrementSpeed(brakeFactor);
    }

    /**
     * The speed factor of the car, which depends on the turbo of the car and the engine power.
     * @return returns the current speed factor.
     */
    @Override
    public double speedFactor() {
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

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