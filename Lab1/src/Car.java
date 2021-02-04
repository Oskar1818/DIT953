import java.awt.*;

public abstract class Car extends Vehicle implements ITransportable{

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
