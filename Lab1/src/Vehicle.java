import java.awt.*;

public abstract class Vehicle implements IMovable{

    private double xCord;
    private double yCord;
    private Direction dir;
    private Color color;
    private String name;
    private double speed;
    private double enginePower;
    private int nrDoors;

    public Vehicle(Color color, double enginePower, int nrDoors, String name, Point p, Direction dir){
        this.color = color;
        this.enginePower = enginePower;
        this.nrDoors = nrDoors;
        this.name = name;
        this.xCord = p.getX();
        this.yCord = p.getY();
        this.dir = dir;
    }


    // From ICar
    public int getNrDoors(){ return this.nrDoors; }

    public double getEnginePower(){ return enginePower; }

    public void startEngine(){ speed = 1; }

    public void stopEngine(){ speed = 0; }

    public void gas(double amount) {
        double gasFactor = Math.max(Math.min(amount, 1), 0);
        incrementSpeed(gasFactor);
    }

    public void brake(double amount) {
        double brakeFactor = Math.max(Math.min(amount, 1), 0); // 0 <= breakFactor <= 1
        decrementSpeed(brakeFactor);
    }


    // From IVehicle
    public String getName(){ return this.name; }

    public String getColor(){ return color.toString(); }

    // interface functions
    @Override
    public void setDirection(Direction d) { this.dir = d; }

    @Override
    public Direction getDirection() { return this.dir; }


    @Override
    public void incrementSpeed(double amount){
        setSpeed(Math.min(getSpeed() + speedFactor() * amount, getEnginePower()));
    }

    @Override
    public void decrementSpeed(double amount){
        setSpeed(Math.max(getSpeed() - speedFactor() * amount,0));
    }


    @Override
    public void setXCord(double x) { this.xCord = x; }

    @Override
    public double getXCord() { return this.xCord; }

    @Override
    public void setYCord(double y) { this.yCord = y;}

    @Override
    public double getYCord() { return this.yCord; }

    @Override
    public void setSpeed(double speed){ speed = Math.min(speed, this.enginePower); }

    @Override
    public double getSpeed(){ return speed; }

}
