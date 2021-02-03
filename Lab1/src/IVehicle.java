import java.awt.*;
//hello
public interface IVehicle {

    /**
     * @return Returns vehicle name.
     */
    String getName();

    /**
     * @return Returns vehicle colour.
     */
    String getColor();

    /**
     *
     * @param d sets direction.
     */
    void setDir(Direction d);

    /**
     * @return Returns direction of vehicle.
     */
    Direction getDir();

    /**
     * Describes a method that is supposed to moves some vehicle forward.
     */
    void move();

    /**
     * Turns the car right, by changing the latitude or the longitude, depending on where the car is pointing.
     */
    void turnRight();

    /**
     * Turns the car left, by changing the latitude or the longitude, depending on where the car is pointing.
     */
    void turnLeft();
    /**
     * Sets the x-coordinate of the vehicle.
     */
    void setXCord(double x);

    /**
     * @return Returns x coordinate of vehicle.
     */
    double getXCord();

    /**
     * Sets the y-coordinate of the vehicle.
     */
    void setYCord(double y);

    /**
     * @return Returns y coordinate of vehicle.
     */
    double getYCord();

    /**
     * @param speed the desired speed.
     */
    void setSpeed(double speed);

    /**
     *
     * @return Gets speed.
     */
    double getSpeed();

    /**
     * The speed factor of the car, which depends on the turbo of the car and the engine power.
     * @return returns the current speed factor.
     */
    double speedFactor();

    /**
     * Makes the car go faster by increasing the speed via the incrementSpeed method.
     * @param amount amount the amount at which the speed should increase by.
     */
    void gas(double amount);

    /**
     * Increases the speed of the Saab by the input amount times the speed factor, and makes sure the
     * speed doesn't exceed the engine power.
     * @param amount amount the amount at which the speed should decrease by.
     */
    void incrementSpeed(double amount);

    /**
     * Makes the car go slower by decreasing the speed via the decrementSpeed method.
     * @param amount amount amount the amount at which the speed should decrease by.
     */
    void brake(double amount);

    /**
     * Decreases the speed of the Saab by the input amount times the speed factor, and makes sure the
     * speed doesn't go below 0.
     * @param amount amount the amount at which the speed should decrease by.
     */
    void decrementSpeed(double amount);

}
