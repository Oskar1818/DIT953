import java.awt.*;
import java.util.Deque;

public class MercedesBlueWonder implements ITruck {

    private double xCord;
    private double yCord;
    private Direction dir;
    private Color color;
    private final String name = "Volvo240";
    private double currentSpeed = 0;
    private final double enginePower = 100;
    private final int nrDoors = 4;
    private int capacity;
    private final Deque<ICar> load;

    private boolean rampOpen;

    // From ITruck
    @Override
    public int getNrDoors() {
        return 0;
    }

    @Override
    public double getEnginePower() {
        return 0;
    }

    @Override
    public void startEngine() {

    }

    @Override
    public void stopEngine() {

    }


    // From IVehicle
    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getColor() {
        return null;
    }

    @Override
    public Direction getDir() {
        return null;
    }

    @Override
    public void move() {

    }

    @Override
    public void turnRight() {

    }

    @Override
    public void turnLeft() {

    }

    @Override
    public double getXCord() {
        return 0;
    }

    @Override
    public double getYCord() {
        return 0;
    }

    @Override
    public void setSpeed(double speed) {

    }

    @Override
    public double getSpeed() {
        return 0;
    }

    @Override
    public double speedFactor() {
        return 0;
    }

    @Override
    public void gas(double amount) {

    }

    @Override
    public void incrementSpeed(double amount) {

    }

    @Override
    public void brake(double amount) {

    }

    @Override
    public void decrementSpeed(double amount) {

    }
}
