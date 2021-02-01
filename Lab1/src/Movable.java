public interface Movable {

    /**
     * @author Valter Miari, Oskar Sturebrand, Clara Josefsson
     */

    /**
     * Describes a method that is supposed to moves some object forward.
     */
    void move();

    /**
     * Describes a method that is supposed to turn a object to the left.
     */
    void turnLeft();

    /**
     * Describes a method that is supposed to turn a object to the right.
     */
    void turnRight();

    /**
     * Describes the speed factor of some movable object.
     * @return should return the speed factor.
     */
    double speedFactor();

    /**
     * Describes a method that should increse the speed of the object.
     * @param amount the amount at which the speed should be increased by.
     */
    void incrementSpeed(double amount);

    /**
     * Describes a method that should increase the speed of the object.
     * @param amount the amount at which the speed should be increased by.
     */
    void decrementSpeed(double amount);

    /**
     * Describes a method that increases the speed of the vehicle.
     * @param amount how much the vehicle should gas by.
     */
    void gas(double amount);

    /**
     * Describes a method that decreases the speed of the vehicle.
     * @param amount how much the vehicle should break by.
     */
    void brake(double amount);

    double getSpeed();

    void setSpeed(double speed);



}
