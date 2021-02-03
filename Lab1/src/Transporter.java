import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

public abstract class Transporter<T extends Vehicle> extends Vehicle{

    private final int capacity;
    private final Deque<T> load;
    private boolean rampOpen;

    public Transporter(Color color, double enginePower, int nrDoors, String name, Point p, Direction dir, int capacity){
        super(color, enginePower, nrDoors, name, p, dir);
        this.capacity = capacity;
        this.load = new ArrayDeque<>(capacity);
        this.rampOpen = false;
    }

    // These could need some tweaking!
    public void rampDown(){
        if (getSpeed() != 0)
            System.out.println("Car must not move!");
        else
            rampOpen = true;
    }

    public void loadTransport(T vehicle){
        if (!rampOpen)
            System.out.println("Ramp must be open!");
        else{
            if (getYCord() - vehicle.getXCord() > 1 | load.size() - 1 >= capacity)
                System.out.println("Must move car closer");
            else {
                load.add(vehicle);
                vehicle.setXCord(getXCord());
                vehicle.setYCord(getYCord());
            }
        }
    }


    public void unloadTransport(){
        T vehicle = load.pollLast();
        vehicle.setXCord(vehicle.getXCord() + 1); // why?
        vehicle.setYCord(vehicle.getYCord() + 1);
    };

    @Override
    public void move () {
        if (rampOpen) {
            System.out.println("Kan inte köra med flaket öppet");
        }
        else {
            switch (getDirection()) {
                case EAST: setXCord(getXCord() + getSpeed()); for (T v : load) v.setXCord(getXCord() + getSpeed());

                case WEST: setXCord(getXCord() - getSpeed()); for (T v : load) v.setXCord(getXCord() - getSpeed());

                case NORTH: setYCord(getYCord() + getSpeed()); for (T v : load) v.setYCord(getYCord() + getSpeed());

                case SOUTH: setYCord(getYCord() + getSpeed()); for (T v : load) v.setYCord(getYCord() + getSpeed());
            }
    }
    // the minus here could be wrong, check later

    @Override
    public void turnRight() {
        if (rampOpen) {
            System.out.println("Kan inte köra med flaket öppet");
        }
        else {
            switch (getDirection()) {
                case EAST: setDirection(Direction.SOUTH); for (T v : load) v.setDirection(Direction.SOUTH);
                case WEST: setDirection(Direction.NORTH); for (T v : load) v.setDirection(Direction.NORTH);
                case NORTH: setDirection(Direction.EAST); for (T v : load) v.setDirection(Direction.EAST);
                case SOUTH: setDirection(Direction.WEST); for (T v : load) v.setDirection(Direction.WEST);
            }
        }
    }

    @Override
    public void turnLeft() {
        if (rampOpen) {
            System.out.println("Kan inte köra med flaket öppet");
        }
        else {
            switch (getDirection()) {
                case EAST: setDirection(Direction.NORTH); for (T v : load) v.setDirection(Direction.NORTH);
                case WEST: setDirection(Direction.SOUTH); for (T v : load) v.setDirection(Direction.SOUTH);
                case NORTH: setDirection(Direction.WEST); for (T v : load) v.setDirection(Direction.WEST);
                case SOUTH: setDirection(Direction.EAST); for (T v : load) v.setDirection(Direction.EAST);
            }
        }
    }

}
