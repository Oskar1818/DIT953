import java.awt.*;

/**
 * A class for the cars of model Saab95. Saab95 is a subclass of Car, it inherits the methods and
 * variables of the abstract class Car. Saab95 also implements the interface Movable, which describes the desired
 * methods for which the car should implement, to be able to move.
 */
public class Saab95 extends Car implements Movable{

    public boolean turboOn;
    private double xCord;
    private double yCord;
    private Direction dir;

    /**
     * The constructor that is called upon on creation of a Saab95.
     * @param c The color of the car.
     * @param point The starting position of the car. An x- and a y-coordinate.
     */
    public Saab95(Color c, Point point){
        super(2, 125, 10, c, "Saab95");
	    turboOn = false;
	    this.xCord = point.getX();
	    this.yCord = point.getY();
	    dir = Direction.NORTH;
        stopEngine();
    }

    public double getXCord() { return this.xCord; }

    public double getYCord() {
        return this.yCord;
    }

    @Override
    public void move() {
        switch (dir) {
            case EAST -> xCord += getCurrentSpeed();
            case WEST -> xCord -= getCurrentSpeed();
            case NORTH -> yCord += getCurrentSpeed();
            case SOUTH -> yCord -= getCurrentSpeed();
        }
    }

    @Override
    public void turnLeft() {
        switch (dir) {
            case EAST -> this.dir = Direction.NORTH;
            case WEST -> this.dir = Direction.SOUTH;
            case NORTH -> this.dir = Direction.EAST;
            case SOUTH -> this.dir = Direction.WEST;
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
    public void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    @Override
    public void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }

    @Override
    public void gas(double amount) {
        if (amount >= 0) {
            double gasFactor = Math.max(Math.min(amount, 1), 0);
            setCurrentSpeed(getCurrentSpeed() + gasFactor);
        }
    }

    @Override
    public void brake(double amount) {
        if (amount >= 0) {
            double brakeFactor = Math.max(Math.min(amount, 1), 0);
            setCurrentSpeed(getCurrentSpeed() - brakeFactor);
        }
    }

    @Override
    public double speedFactor() {
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }

}