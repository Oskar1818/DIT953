import java.awt.*;

public class Saab95 extends Car implements Movable{

    public boolean turboOn;
    private static int xCord;
    private static int yCord;
    private Direction dir;
    
    public Saab95(){
        super(2, 125, 10, Color.red, "Saab95");
	    turboOn = false;
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
        if (amount >= 0) {
            double gasFactor = Math.max(Math.min(amount, 1), 0);
            setCurrentSpeed(getCurrentSpeed() + gasFactor);
        }
    }

    @Override
    public void brake(double amount) {
        if (amount >= 0) {
            double brakeFactor = Math.max(Math.min(amount, 1), 0);
            setCurrentSpeed(getCurrentSpeed() - brakeFactor);
        }
    }

    @Override
    public double speedFactor() {
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }

}