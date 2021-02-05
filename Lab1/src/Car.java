import java.awt.*;

/**
 * The abstract base class for all cars.
 */
public abstract class Car extends Vehicle implements ITransportable{

    /**
     * @param color The color of the car.
     * @param enginePower The engine power of the car.
     * @param nrDoors The number of doors the car has.
     * @param name The name of the specific car.
     * @param point The starting position of the car. An x- and a y-coordinate.
     * @param dir The initial direction of the car.
     */
    public Car(Color color, double enginePower, int nrDoors, String name, Point point, Direction dir){
        super(color, enginePower, 0, nrDoors, name, point, dir);
    }

    @Override
    public void move() {
        switch (getDirection()) {
            case EAST -> setXCord(getXCord() + getSpeed());
            case WEST -> setXCord(getXCord() - getSpeed());
            case NORTH -> setYCord(getYCord() + getSpeed());
            case SOUTH -> setYCord(getYCord() - getSpeed());
        }
    }

    @Override
    public void turnRight() {
        switch (getDirection()) {
            case EAST -> setDirection(Direction.SOUTH);
            case WEST -> setDirection(Direction.NORTH);
            case NORTH -> setDirection(Direction.EAST);
            case SOUTH -> setDirection(Direction.WEST);
        }
    }

    @Override
    public void turnLeft() {
        switch (getDirection()) {
            case EAST -> setDirection(Direction.NORTH);
            case WEST -> setDirection(Direction.SOUTH);
            case NORTH -> setDirection(Direction.WEST);
            case SOUTH -> setDirection(Direction.EAST);
        }
    }


}
