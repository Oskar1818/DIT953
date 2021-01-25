import java.awt.*;

public class Volvo240 extends Car implements Movable {

    public final static double trimFactor = 1.25;
    private double xCord;
    private double yCord;
    private Direction dir;
    //private static direction =

    public Volvo240(Color c, Point point){
        super(4, 100, 0, c, "Volvo240");
        this.xCord = point.getX();
        this.yCord = point.getY();
        dir = Direction.NORTH;
        stopEngine();
    }

    public double getXCord() {
        return this.xCord;
    }

    public double getYCord() {
        return this.yCord;
    }


    @Override
    public void move() {
        switch (dir) {
            case EAST -> this.xCord += getCurrentSpeed();
            case WEST -> this.xCord -= getCurrentSpeed();
            case NORTH -> this.yCord += getCurrentSpeed();
            case SOUTH -> this.yCord -= getCurrentSpeed();
        }
    }


    @Override
    public void turnLeft() {
        switch (dir) {
            case EAST -> this.dir = Direction.NORTH;
            case WEST -> this.dir = Direction.SOUTH;
            case NORTH -> this.dir = Direction.EAST;
            case SOUTH -> this.dir = Direction.WEST;
        }
    }

    @Override
    public void turnRight() {
        switch (dir) {
            case EAST -> this.dir = Direction.SOUTH;
            case WEST -> this.dir = Direction.NORTH;
            case NORTH -> this.dir = Direction.EAST;
            case SOUTH -> this.dir = Direction.WEST;
        }
    }

    @Override
    public void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    @Override
    public void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }

    @Override
    public void gas(double amount) {
        double newSpeed = Math.max(Math.min(amount,1), 0);
        setCurrentSpeed(getCurrentSpeed() + newSpeed);

    }

    /**
     *
     * @param amount
     */
    @Override
    public void brake(double amount) {
    }

    /**
     *
     * @return
     */
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }


}
