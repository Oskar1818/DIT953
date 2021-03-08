package model.interfaces;

public interface IMove {

    IMove move();

    IMove turnRight();

    IMove turnLeft();

    IMove setSpeed(double d);

    double getSpeed();

    IMove incrementSpeed(double amount);

    IMove decrementSpeed(double amount);

    double speedFactor();
}
