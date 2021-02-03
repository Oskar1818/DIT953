import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class MercedesBlueWonder implements ITruck {

    private double xCord;
    private double yCord;
    private Direction dir;
    private final Color color;
    private final String name = "The Blue Wonder";
    private double Speed = 0;
    private final double enginePower = 200;
    private final int nrDoors = 2;
    private int capacity;
    private final Deque<ICar> load;

    private boolean rampOpen;

    public MercedesBlueWonder(Color c, Point point, Direction dir, int capacity){
        this.xCord = point.getX();
        this.yCord = point.getY();
        this.color = Color.blue;
        this.dir = dir;
        this.capacity = capacity;
        this.load = new ArrayDeque<>(capacity);
        this.rampOpen = false;
        stopEngine();
    }

    // From ITruck
    @Override
    public int getNrDoors() {return this.nrDoors;}

    @Override
    public double getEnginePower() {return this.enginePower; }

    @Override
    public void startEngine() {

    }

    @Override
    public void stopEngine() {

    }

    @Override
    public double getBedAngle() {
        return 0;
    }

    @Override
    public void setBedAngle(double d) {

    }


    // From IVehicle
    @Override
    public String getName() {return this.name; }

    @Override
    public String getColor() {return color.toString(); }

    @Override
    public void setDir(Direction d) { this.dir = d; }

    @Override
    public Direction getDir() {return this.dir; }

    @Override
    public void move () {
        if (rampOpen) {
            System.out.println("Kan inte köra med flaket öppet");
        }
        else {
            switch (dir) {
                case EAST: this.xCord += getSpeed(); for (ICar c : load) c.setXCord(this.xCord += getSpeed());
                case WEST: this.xCord -= getSpeed(); for (ICar c : load) c.setXCord(this.xCord -= getSpeed());
                case NORTH: this.yCord += getSpeed(); for (ICar c : load) c.setYCord(this.yCord += getSpeed());
                case SOUTH: this.yCord -= getSpeed(); for (ICar c : load) c.setYCord(this.yCord -= getSpeed());
            }
        }
    }

    @Override
    public void turnRight() {
        if (rampOpen) {
            System.out.println("Kan inte köra med flaket öppet");
        }
        else {
            switch (dir) {
                case EAST: this.dir = Direction.SOUTH; for (ICar c : load) c.setDir(Direction.SOUTH);
                case WEST: this.dir = Direction.NORTH; for (ICar c : load) c.setDir(Direction.NORTH);
                case NORTH: this.dir = Direction.EAST; for (ICar c : load) c.setDir(Direction.EAST);
                case SOUTH: this.dir = Direction.WEST; for (ICar c : load) c.setDir(Direction.WEST);
            }
        }
    }

    @Override
    public void turnLeft() {
        if (rampOpen) {
            System.out.println("Kan inte köra med flaket öppet");
        }
        else {
            switch (dir) {
                case EAST: this.dir = Direction.NORTH; for (ICar c : load) c.setDir(Direction.NORTH);
                case WEST: this.dir = Direction.SOUTH; for (ICar c : load) c.setDir(Direction.SOUTH);
                case NORTH: this.dir = Direction.WEST; for (ICar c : load) c.setDir(Direction.WEST);
                case SOUTH: this.dir = Direction.EAST; for (ICar c : load) c.setDir(Direction.EAST);
            }
        }
    }

    @Override
    public void setXCord(double x) { this.xCord = x; }

    @Override
    public double getXCord() {return this.xCord; }

    @Override
    public void setYCord(double y) { this.yCord = y;}

    @Override
    public double getYCord() {return this.yCord; }

    @Override
    public void setSpeed(double speed){ Speed = Math.min(speed, this.enginePower); }

    @Override
    public double getSpeed() {return this.Speed; }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    @Override
    public void gas(double amount) {
        double gasFactor = Math.max(Math.min(amount, 1), 0);
        incrementSpeed(gasFactor);
    }

    @Override
    public void incrementSpeed(double amount){
        setSpeed(Math.min(getSpeed() + speedFactor() * amount, getEnginePower()));
    }

    @Override
    public void brake(double amount) {
        double brakeFactor = Math.max(Math.min(amount, 1), 0); // 0 <= breakFactor <= 1
        decrementSpeed(brakeFactor);
    }

    @Override
    public void decrementSpeed(double amount){
        setSpeed(Math.max(getSpeed() - speedFactor() * amount,0));
    }

}
