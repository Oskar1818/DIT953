public interface Movable {

    /**
     * @author Valter Miari, Oskar Sturebrand, Clara Josefsson
     */

    void move();
    void turnLeft();
    void turnRight();

    double speedFactor();

    void incrementSpeed(double amount);

    void decrementSpeed(double amount);

    void gas(double amount);

    void brake(double amount);

}
