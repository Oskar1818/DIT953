public interface Movable {

    void move();
    void turnLeft();
    void turnRight();

    double speedFactor();

    void incrementSpeed(double amount);

    void decrementSpeed(double amount);

    void gas(double amount);

    void brake(double amount);

}
