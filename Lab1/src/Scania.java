import java.awt.*;

public class Scania implements ITruck{

    private double xCord;
    private double yCord;
    private Direction dir;
    private final String name = "Scania";
    private Color color;
    private double speed = 0;
    private final double enginePower = 500;
    private final int nrDoors = 2;

    private double bedAngle;


    public Scania(Color c, Point point, Direction dir){
        this.xCord = point.getX();
        this.yCord = point.getY();
        this.color = c;
        this.dir = dir;
        this.bedAngle = 0;
        stopEngine();
    }


    // Specific to Scania
    @Override
    public double getBedAngle () { return this.bedAngle; }

    /**
     * Sets the angle at which the bed should tilt.
     * @param a The specified angel, which cannot go beyond 70 degrees or beneath 0 degrees.
     */
    @Override
    public void setBedAngle (double a) {
        if (getSpeed() != 0) {
            System.out.println("Cannot tilt while moving!");
        } else {
            this.bedAngle = Math.max(Math.min(a, 70), 0);
        }
    }


    // From ITruck
    @Override
    public int getNrDoors(){ return this.nrDoors; }

    @Override
    public double getEnginePower(){ return enginePower; }

    @Override
    public void startEngine(){ speed = 1; }

    @Override
    public void stopEngine(){ speed = 0; }


    // From IVehicle
    @Override
    public String getName(){ return this.name; }

    @Override
    public String getColor() {return color.toString(); }

    @Override
    public void setDir(Direction d) { this.dir = d; }

    @Override
    public Direction getDir() { return this.dir; }

    @Override
    public void move () {
        if (bedAngle != 0) {
            System.out.println("Kan inte köra med flaket öppet");
        }
        else {
            switch (dir) {
                case EAST -> this.xCord += getSpeed();
                case WEST -> this.xCord -= getSpeed();
                case NORTH -> this.yCord += getSpeed();
                case SOUTH -> this.yCord -= getSpeed();
            }
        }
    }

    @Override
    public void turnRight() {
        if (bedAngle != 0) {
            System.out.println("Kan inte köra med flaket öppet");
        }
        else {
            switch (dir) {
                case EAST -> this.dir = Direction.SOUTH;
                case WEST -> this.dir = Direction.NORTH;
                case NORTH -> this.dir = Direction.EAST;
                case SOUTH -> this.dir = Direction.WEST;
            }
        }
    }

    @Override
    public void turnLeft() {
        if (bedAngle != 0) {
            System.out.println("Kan inte köra med flaket öppet");
        }
        else {
            switch (dir) {
                case EAST -> this.dir = Direction.NORTH;
                case WEST -> this.dir = Direction.SOUTH;
                case NORTH -> this.dir = Direction.WEST;
                case SOUTH -> this.dir = Direction.EAST;
            }
        }
    }

    @Override
    public void setXCord(double x) { this.xCord = x; }

    @Override
    public double getXCord() { return this.xCord; }

    @Override
    public double getYCord() {
        return this.yCord;
    }

    @Override
    public void setYCord(double y) { this.yCord = y;}

    @Override
    public void setSpeed(double speed){ speed = Math.min(speed, this.enginePower); }

    @Override
    public double getSpeed(){ return speed; }

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
