import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

public abstract class Transporter<T extends ITransportable> extends Vehicle implements ITransporter<T>{

    private final int capacity;
    private final Deque<T> load;
    private double rampAngle;

    public Transporter(Color color, double enginePower, int nrDoors, String name, Point p, Direction dir, int capacity){
        super(color, enginePower, nrDoors, name, p, dir);
        this.capacity = capacity;
        this.load = new ArrayDeque<>(capacity);
        this.rampAngle = 0;
    }

    /**
     * Sets the angle at which the ramp should tilt.
     * @param a The specified angel, which cannot go beyond 70 degrees or beneath 0 degrees.
     */
    public void setRampAngle(double a){
        if (getSpeed() != 0)
            System.out.println("Car must not move!");
        else
            rampAngle = Math.max(Math.min(a, 70), 0);
    }

    public double getRampAngle() {
        return this.rampAngle;
    }

    public void setRampDown(){
        rampAngle = 0;
    }

    public boolean isRampDown(){
        if (rampAngle > 50)
            return true;
        else
            return false;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public int getLoadSize(){
        return this.load.size();
    }

    @Override
    public Deque<T> getLoad(){
        return load;
    }

    @Override
    public T unload(){
        return load.getLast();
    }

    @Override
    public void move () {
        if (isRampDown()) {
            System.out.println("Kan inte köra med flaket öppet");
        } else {
            switch (getDirection()) {
                case EAST:
                    setXCord(getXCord() + getSpeed());
                    for (T v : load) v.setXCord(getXCord() + getSpeed());

                case WEST:
                    setXCord(getXCord() - getSpeed());
                    for (T v : load) v.setXCord(getXCord() - getSpeed());

                case NORTH:
                    setYCord(getYCord() + getSpeed());
                    for (T v : load) v.setYCord(getYCord() + getSpeed());

                case SOUTH:
                    setYCord(getYCord() + getSpeed());
                    for (T v : load) v.setYCord(getYCord() + getSpeed());
            }
        }
    }
        // the minus here could be wrong, check later

    @Override
    public void turnRight () {
        if (isRampDown()) {
            System.out.println("Kan inte köra med flaket öppet");
        } else {
            switch (getDirection()) {
                case EAST:
                    setDirection(Direction.SOUTH);
                    for (T v : load) v.setDirection(Direction.SOUTH);
                case WEST:
                    setDirection(Direction.NORTH);
                    for (T v : load) v.setDirection(Direction.NORTH);
                case NORTH:
                    setDirection(Direction.EAST);
                    for (T v : load) v.setDirection(Direction.EAST);
                case SOUTH:
                    setDirection(Direction.WEST);
                    for (T v : load) v.setDirection(Direction.WEST);
            }
        }
    }

    @Override
    public void turnLeft () {
        if (isRampDown()) {
            System.out.println("Kan inte köra med flaket öppet");
        } else {
            switch (getDirection()) {
                case EAST:
                    setDirection(Direction.NORTH);
                    for (T v : load) v.setDirection(Direction.NORTH);
                case WEST:
                    setDirection(Direction.SOUTH);
                    for (T v : load) v.setDirection(Direction.SOUTH);
                case NORTH:
                    setDirection(Direction.WEST);
                    for (T v : load) v.setDirection(Direction.WEST);
                case SOUTH:
                    setDirection(Direction.EAST);
                    for (T v : load) v.setDirection(Direction.EAST);
            }
        }
    }

}
