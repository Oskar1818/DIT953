import java.awt.*;

public class Saab95 extends Car implements Movable{

    public boolean turboOn;
    
    public Saab95(){
        setNrDoors(2);
        setColor(Color.red);
        setEnginePower(125);
	    turboOn = false;
        setModelName("Saab95");
        stopEngine();
    }

    @Override
    public void move() {
    }

    @Override
    public void turnLeft() {
    }

    @Override
    public void turnRight() {
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
    }

    @Override
    public void brake(double amount) {
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