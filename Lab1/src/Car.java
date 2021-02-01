import java.awt.*;

/**
 * An abstract class representing a car. In the class there are variables and methods which all
 * cars should have.
 * @author Valter Miari, Oskar Sturebrand, Clara Josefsson
 */
public abstract class Car {

    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name


    /**
     * Default constructor of a car.
     * @param d Number of doors.
     * @param ep The power of the engine in the car.
     * @param cs The current speed of the car.
     * @param c The color of the car.
     * @param n The model name of the car.
     */
    public Car(int d, double ep, double cs, Color c, String n){
        this.nrDoors = d;
        this.enginePower = ep;
        this.currentSpeed = cs;
        this.color = c;
        this.modelName = n;
    }

    /**
     *
     * @return Returns the model name of the car.
     */
    public String getModelName(){ return this.modelName; }

    /**
     *
     * @return Returns the number of doors the car has.
     */
    public int getNrDoors(){ return this.nrDoors; }

    /**
     *
     * @return Returns the engine power of the car.
     */
    public double getEnginePower(){ return enginePower; }

    /**
     *
     * @return Returns the speed the car currently has.
     */
    public double getCurrentSpeed(){ return currentSpeed; }

    /**
     * Sets the speed of the car, and makes sure the speed doesn't exceed the engine power of the car.
     * @param speed The desired speed.
     */
    public void setCurrentSpeed(double speed){ currentSpeed = Math.min(speed, this.enginePower); }

    /**
     *
     * @return Returns the color of the car.
     */
    public String getColor(){ return color.toString(); }

    /**
     * Starts the engine and sets the initial speed to 1.
     */
    public void startEngine(){ currentSpeed = 1; }

    /**
     * Stops the engine, which makes the car stop.
     */
    public void stopEngine(){ currentSpeed = 0; }

    // put in respective class, bc interfaces
    public void errorMsg(String s){
        System.out.println(s);
    }

}
