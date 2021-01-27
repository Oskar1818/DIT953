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

    void decrementSpeed(double amount);

    void gas(double amount);

    void brake(double amount);

}
