import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class SSBadger implements ICarTransporter{

    private double xCord;
    private double yCord;
    private Direction dir;
    private final String name = "SSBadger";
    private Color color;
    private double speed = 0;
    private final double enginePower = 2000;
    private final int capacity;
    private final Deque<ICar> load;

    public SSBadger(Color c, Point point, Direction dir, int capacity){
        this.xCord = point.getX();
        this.yCord = point.getY();
        this.color = c;
        this.dir = dir;
        this.capacity = capacity;
        this.load = new ArrayDeque<>(capacity);
    }


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

    @Override
    public void loadTransport(ICar car) {

    }

    @Override
    public void unloadTransport() {
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getColor() {
        return null;
    }

    @Override
    public void setDir(Direction d) {

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
    public void setXCord(double x) {

    }

    @Override
    public double getXCord() {
        return 0;
    }

    @Override
    public void setYCord(double y) {

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
