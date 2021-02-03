public interface IMovable extends IPositionable{

    void move();

    void turnRight();

    void turnLeft();

    void setSpeed(double d);

    double getSpeed();

    void incrementSpeed(double amount);

    void decrementSpeed(double amount);

    double speedFactor();
}
