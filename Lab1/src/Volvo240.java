import java.awt.*;

public class Volvo240 extends Car implements Movable {

    public final static double trimFactor = 1.25;
    private static double xCord;
    private static double yCord;
    private Direction dir;
    //private static direction =

    public Volvo240(){
        super(4, 100, 10, Color.black, "Volvo240");
        xCord = 0;
        yCord = 0;
        dir = Direction.NORTH;
        stopEngine();
    }


    @Override
    public void move() {
        switch (dir) {
            case EAST -> xCord += getCurrentSpeed();
            case WEST -> xCord -= getCurrentSpeed();
            case NORTH -> yCord += getCurrentSpeed();
            case SOUTH -> yCord -= getCurrentSpeed();
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

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }


}
