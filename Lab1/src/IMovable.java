public interface IMovable extends ITransportable{

    void move();

    void turnRight();

    void turnLeft();

    void setSpeed(double d);

    double getSpeed();

    void incrementSpeed(double amount);

    void decrementSpeed(double amount);

    double speedFactor();
}
