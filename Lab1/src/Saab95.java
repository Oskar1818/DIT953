import java.awt.*;

/**
 * A class for the cars of model Saab95. Saab95 is a subclass of Car, it inherits the methods and
 * variables of the abstract class Car. Saab95 also implements the interface Movable, which describes the desired
 * methods for which the car should implement, to be able to move.
 * @author Valter Miari, Oskar Sturebrand, Clara Josefsson
 */
public class Saab95 extends Car {

    private boolean turboOn;

    /**
     * The constructor that is called upon on creation of a Saab95. It inherits the variables; nrDoors, enginePower,
     * speed, color and modelName; from its super class Car. With exception of color, all these variables and the
     * variables; turboOn and dir, have default values for a Saab95, and are assigned a final default value upon
     * creation.
     * @param c The color of the car.
     * @param point The starting position of the car. An x- and a y-coordinate.
     */
    public Saab95(Color color, Point point, Direction dir){
	    super(color, 125.0, 4, "Saab95", point, dir);
        turboOn = false;
        stopEngine();
    }


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


    @Override
    public double speedFactor() {
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    // not sure if we need to define them here, because they are dependant on a method implemented (altough not described)
    // in this class.
   /* @Override
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
*/
}